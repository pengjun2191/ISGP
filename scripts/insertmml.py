import cx_Oracle
import sys


def main(TRANSACTION_ID, ps_net_code, direct_type, oracle_tns):
    file_path = "/data/psserver/scripts/data/directive.txt"
    with open(file_path, 'r') as f:
        colb = f.read();
    id = TRANSACTION_ID
    param = [colb, id, ps_net_code, direct_type]
    # print (param)
    # tns="user/password@ip:port/database"
    conn = cx_Oracle.connect(oracle_tns)
    # sql = "update r_ps_generated_mml pgm set pgm.generated_mml=:1 where pgm.transaction_id=:2"
    sql = "insert into r_ps_generated_mml (TRANSACTION_ID, STATUS, GENERATED_MML, MODIFIEDBY_ID, MODIFIED_DATE, PS_NET_CODE, DIRECT_TYPE) values (:1, 0, :2, -1, to_date('05-03-2021 16:23:28', 'dd-mm-yyyy hh24:mi:ss'), :3, :4);"
    conn.cursor().execute(sql, param)
    conn.commit()
    print(' success')


if __name__ == '__main__':
    if len(sys.argv) >= 5:
        main(sys.argv[1], sys.argv[2], sys.argv[3], sys.argv[4])
    else:
        print('Please input 4 parameters it means TRANSACTION_ID,ps_net_code,direct_type,oracle_tns ,oracle_tns '
              'format "user/password@ip:port/database"')
