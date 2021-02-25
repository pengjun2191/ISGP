import socket
import struct

#ps data define
SW_data_filename='./switchdata.txt'
RC_filename='./RC.txt'
action_id='103'
service_type='AXE_SWITCH'
service='EXEC_TRANSLATION=1;'
status=0

BUFSIZ=1024
addr=('localhost',8103)
s=socket.socket(socket.AF_INET,socket.SOCK_STREAM)
s.connect(addr)


'''rc_queryneed_filename='./queryRC.txt'
        if os.path.isfile(rc_queryneed_filename):
            os.remove(rc_queryneed_filename)
        
        
        def get_data(src_data):
            re_data=src_data.split(' ')
            switch_id=eval(re_data[1])["SWITCHID"]
            write_file(switch_id+' ')
            INSTANCE_ID=eval(re_data[1])["ROUTEPRODUCTID"]
            write_file(INSTANCE_ID+' ')
            ROUTE_CLASS_ID=eval(re_data[1])["ROUTECLASSID"]
            write_file(ROUTE_CLASS_ID+' ')
            ROUTE_ORIGINATION_ID=eval(re_data[1])["ROUTEORIGINID"]
            write_file(ROUTE_ORIGINATION_ID+'\n')
            
        
        def write_file(data):
            result2txt=data        
            with open(rc_queryneed_filename,'a+') as file_handle:   
                file_handle.write(result2txt)    '''        


#use switch_id for ps_ent_code
def get_switch(switch_id):
    return{
        "2":"HKSino",
        "3":"HKGNC",
        "5":"TREquinix",
        "16":"UKTelehouse1",
        "17":"UKTelehouse2"
    }.get(switch_id,"LACoreSite")

#get ps_net_code(SWITCH),switch_id,ps_id(transaction_id),ps_param
def split_data(src_data,RC):
    re_data=src_data.split(' ')
    switch_id=eval(re_data[1])["SWITCHID"]
    ps_net_code=get_switch(switch_id)
    param='{"EXTERNALSYSTEMTYPEID":"9","SWITCHTYPEID":"4","SWITCHID":"'+switch_id+'","COUNTRYID":"","COUNTRYCODE":"","PARTITIONID":[""],"PARTITIONVALUE":[""],"ROUTECASE":"'+RC+'"}'
    return (ps_net_code,switch_id,re_data[0],param)


with open(SW_data_filename, 'r') as f1:
    list1 = f1.readlines()
with open(RC_filename, 'r') as f2:
    RC = f2.readlines()
try:
    for i in range(0, len(list1)):
        list1[i] = list1[i].rstrip('\n')
        RC[i] = RC[i].rstrip('\n')
        (ps_net_code,switch_id,ps_id,ps_param)=split_data(list1[i],RC[i])
        data_all=struct.pack('>4sI20s16s10s32s32s128sI%ds'%(len(ps_param)),'AISC',len(ps_param),ps_net_code,ps_id,action_id,service_type,switch_id,service,status,ps_param)
        if not data_all:
            break
        print (data_all)
        s.send(data_all)
        data_recv=s.recv(BUFSIZ)
        if not data_recv:
            print (ps_id+'has no recv.please check the server.\n')
        print (data_recv)
except Exception as err:
    print (err)
else:
    s.close()