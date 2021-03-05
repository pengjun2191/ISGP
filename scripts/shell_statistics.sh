#!/bin/bash
#����ű�ʹ����ͳ��CPU�����̡��ڴ�ʹ���ʡ������
total=0
system=0
user=0
i=0

#����ʹ�����
file_time=`date "+%Y%m%d%k%M"`
time=`date "+%Y-%m-%d %k:%M"`
day=`date "+%Y-%m-%d"`
minute=`date "+%k:%M"`
echo  "*************************************************************************" >> statistic_$file_time.txt
echo "ͳ�ƿ�ʼʱ�䣺$day $minute" >> statistic_$file_time.txt

#ѭ����Σ����⿴������żȻ������
echo "#�����ʹ�������#" >>statistic_$file_time.txt
while (( $i<5 ))
do
#ԭ�ȵ�`ifconfig eth0|sed -n "7p"|awk '{print $2}'|cut -c7-`��ʽ��ȡ��������ϢΪ�գ��Ѿ�ע�͵�
#rx_before=`ifconfig eth0|sed -n "7p"|awk '{print $2}'|cut -c7-`
#tx_before=`ifconfig eth0|sed -n "7p"|awk '{print $6}'|cut -c7-`
rx_before=$(cat /proc/net/dev | grep 'eth' | tr : " " | awk '{print $2}')
tx_before=$(cat /proc/net/dev | grep 'eth' | tr : " " | awk '{print $10}')
sleep 2
#rx_after=`ifconfig eth0|sed -n "7p"|awk '{print $2}'|cut -c7-`
#tx_after=`ifconfig eth0|sed -n "7p"|awk '{print $6}'|cut -c7-`
rx_after=$(cat /proc/net/dev | grep 'eth' | tr : " " | awk '{print $2}')
tx_after=$(cat /proc/net/dev | grep 'eth' | tr : " " | awk '{print $10}')

rx_result=$[(rx_after-rx_before)/1024/1024/2*8]
tx_result=$[(tx_after-tx_before)/1024/1024/2*8]
echo  "$time Now_In_Speed: $rx_result Mbps Now_OUt_Speed: $tx_result Mbps" >>statistic_$file_time.txt

let "i++"
done

rx_result=$(cat statistic_$file_time.txt|grep "$time"|awk '{In+=$4}END{print In}')
tx_result=$(cat statistic_$file_time.txt|grep "$time"|awk '{Out+=$7}END{print Out}')
In_Speed=$(echo "scale=2;$rx_result/5"|bc)
Out_Speed=$(echo "scale=2;$tx_result/5"|bc)
#echo "#�����5�ε�ƽ��ֵ�ǣ�#" >>statistic_$file_time.txt
echo  "$time In_Speed_average: $In_Speed Mbps Out_Speed_average: $Out_Speed Mbps" >>statistic_$file_time.txt

#CPUʹ�����
#which sar > /dev/null
#if [ $? -ne 0 ]
#then
  total=`vmstat 1 5|awk '{x+=$13;y+=$14}END{print x+y}'`
  echo "$total"
  average=$(echo "scale=2;$total/5"|bc)
#fi
echo "#CPUʹ����:#" >>statistic_$file_time.txt
echo "Total CPU  is already use(%): $average" >>statistic_$file_time.txt
#����ʹ�����(ע�⣺��Ҫ��sed�Ƚ��и�ʽ�����ܽ����ۼӴ���)
disk_used=$(df -m | sed '1d;/ /!N;s/\n//;s/ \+/ /;' | awk '{used+=$3} END{print used}')
disk_totalSpace=$(df -m | sed '1d;/ /!N;s/\n//;s/ \+/ /;' | awk '{totalSpace+=$2} END{print totalSpace}')
disk_all=$(echo "scale=4;$disk_used/$disk_totalSpace" | bc)
disk_percent1=$(echo $disk_all | cut -c 2-3)
disk_percent2=$(echo $disk_all | cut -c 4-5)
disk_warning=`df -m | sed '1d;/ /!N;s/\n//;s/ \+/ /;' | awk '{if ($5>85) print $5 $6;} '`
echo "#����������#" >>statistic_$file_time.txt
echo "hard disk has used: $disk_percent1.$disk_percent2%" >>statistic_$file_time.txt
echo -e "\t\t#���̴���Ŀ¼ʹ���ʳ���85%����#" >>statistic_$file_time.txt
echo -e "\t\tover used: $disk_warning" >>statistic_$file_time.txt


#�ڴ�ʹ�����
memery_used=$(free -m | awk 'NR==2' | awk '{print $3}')
buffer_used=$(free -m | awk 'NR==2' | awk '{print $6}')
cache_used=$(free -m | awk 'NR==2' | awk '{print $7}')
free=$(free -m | awk 'NR==2' | awk '{printf $4}')
memery_all=$(free -m | awk 'NR==2' | awk '{print $2}')
used_all=$[memery_all-(free+buffer_used+cache_used)]
echo "$used_all $memery_all $free" >>statistic_$file_time.txt
memery_percent=$(echo "scale=4;$memery_used / $memery_all" | bc)
memery_percent2=$(echo "scale=4; $used_all / $memery_all" | bc)
percent_part1=$(echo $memery_percent | cut -c 2-3)
percent_part2=$(echo $memery_percent | cut -c 4-5) 
percent_part11=$(echo $memery_percent2 | cut -c 2-3)
percent_part22=$(echo $memery_percent2 | cut -c 4-5)
echo "#�ڴ�ʹ����#" >> statistic_$file_time.txt
echo "system memery is already use: $percent_part1.$percent_part2%" >>statistic_$file_time.txt
echo "actual memery is already use: $percent_part11.$percent_part22%" >>statistic_$file_time.txt

echo  "��������ͳ�ƣ�$day $minute" >> statistic_$file_time.txt
echo  "*************************************************************************" >> statistic_$file_time.txt
echo -e "\n\n\n\n" >> statistic_$file_time.txt
