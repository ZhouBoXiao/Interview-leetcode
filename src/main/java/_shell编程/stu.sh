#!/bin/bash

## 统计单词频率
awk '{for (i = 1; i <=NF; i++}{print $i}}' words.txt

cat words.txt | xargs -n1 | sort | uniq -c | sort -rn | awk '{ print $2 " " $1}'

cat words.txt | tr ' ' '\n' | sort | uniq -c | sort -rn | awk '{ print $2 " " $1}'

awk '{for(i=1;i<=NF;i++){asso_array[$i]++;}};END{for(w in asso_array){print w,asso_array[w];}}' words.txt | sort -rn -k2


awk '{for(i=1;i<=NF;i++){
  array[$i]++;
}};END{for (w in array) {
    print w, array[w];
}}' words.txt | sort -rn -k2

## 第十行
awk "NR == 10" file.txt
sed -n p10 file.txt
tail -n+10 file.txt | head -1
count=0
while read line; do
    count=$[$count+1] # ((count++))
    if [ $count -eq 10 ];then
        echo $line
    fi
done < file.txt

## 有效电话号码

awk '/^([0-9]{3}-|\([0-9]{3}\) )[0-9]{3}-([0-9]{4})$/' file.txt


## 转置文件

awk '{
    for (i=1; i<=NF; i++){
        if  (NR == 1) {
            res[i] = $i;
        } else {
            res[i] = res[i] " " $i
        }
    }
}
END {

    for (i = 1; i<=NF; i++){
        print res[i]
    }
}' file.txt