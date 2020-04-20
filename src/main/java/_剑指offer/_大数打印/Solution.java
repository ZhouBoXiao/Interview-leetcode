package _剑指offer._大数打印;

import java.util.*;

public class Solution {
    public int[] printNumbers(int n) {
        //使用数组来存储大数
        char[] numbers=new char[n];
        Arrays.fill(numbers,'0');
        ArrayList<Integer> res=new ArrayList<>();
        //开始运算
        while(!incrementNumber(numbers)){
            saveNumber(numbers,res);
        }
        //jdk 1.8 stream流将列表转换成数组
        int[] result = res.stream().mapToInt(Integer::valueOf).toArray();
        return result;
    }
    //递增
    public boolean incrementNumber(char[] numbers){
        //结束标识
        boolean isBreak=false;
        //进位标识
        int carryFlag=0;
        int l=numbers.length;
        for(int i=l-1;i>=0;i--){
            //char型转换成int(同时将低位的进位增加)
            int sumArr=numbers[i]-'0'+carryFlag;
            //最低位加1
            if(i==l-1){
                sumArr++;
            }
            //判断是否进位
            if(sumArr>=10){
                //判断是否已经超过最大值
                if(i==0){
                    //超出最大值,结束
                    isBreak=true;
                }else{
                    //未超出最大值,进位,减10
                    numbers[i]=(char)(sumArr-10+'0');
                    carryFlag=1;
                }
            }else{
                numbers[i]=(char)(sumArr+'0');
                break;
            }
        }
        return isBreak;
    }
    //输出
    public void saveNumber(char[] numbers,ArrayList<Integer> res){
        boolean isBreak=true;
        int temp=0;
        for(int i=0;i<numbers.length;i++){
            if(isBreak && numbers[i]!='0'){
                isBreak=false;
            }
            if(!isBreak){
                //如果是超大值，肯定输出不了
                temp=temp*10+(int)(numbers[i]-'0');
                System.out.println(numbers[i]);
            }
        }
        res.add(temp);
    }
}
