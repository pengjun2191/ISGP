import socket
import struct
import sys

def main(ip,port,ps_net_code,switch_id,TRANSACTION_ID):
    BUFSIZ=1024
    #addr=('10.19.14.35',8104)
    addr=(ip,port)
    s=socket.socket(socket.AF_INET,socket.SOCK_STREAM)
    s.connect(addr)
    #ps_net_code in (TREqunix,UKTelehouse1,UKTelehouse2)
    #ps_id='123'
    ps_id=TRANSACTION_ID
    action_id='103'
    service_type='AXE_SWITCH'
    #switch_id in (5,16,17)
    service='EXEC_TRANSLATION=1;'
    data='{"SWITCHID":'+switch_id+',"EXTERNALSYSTEMTYPEID":"9","SWITCHTYPEID":"4","COUNTRYID":"","COUNTRYCODE":"","PARTITIONID":[""],"PARTITIONVALUE":[""],"ROUTECASE":"666"}'
    status=0
    try:
        while True:
            data_all=struct.pack('>4sI20s16s10s32s32s128sI%ds'%(len(data)),'AISC',len(data),ps_net_code,ps_id,action_id,service_type,switch_id,service,status,data)
           # print repr(data_all)
           # print (struct.unpack('>4sI20s16s10s32s32s128sI%ds'%(len(data)),data_all))
            if not data_all:
                break
            s.send(data_all)
            data_recv=s.recv(BUFSIZ)
            if not data_recv:
                break
            print (data_recv)
    except Exception as err:
        print (err)
    else:
        s.close()

if __name__ == '__main__':
    if sys.argv[5] is not None:
        main(sys.argv[1],sys.argv[2],sys.argv[3],sys.argv[4],sys.argv[5])
    else:
        print ('Please input 5 parameters it means ip,port,ps_net_code,switch_id,TRANSACTION_ID')
