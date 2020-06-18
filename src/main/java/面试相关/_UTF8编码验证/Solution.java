package 面试相关._UTF8编码验证;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/6/12 13:18
 */
public class Solution {
    public boolean validUtf8(int[] data) {
        int i = 0;
        while (i < data.length) {

            // 0x80: 10000000, 0x40: 01000000
            // 也可以用 mark = 1 << 7 代替
            int mark = 0x80, count = 0;

            // 获取对应位置的字节数，注意字节数为1时count为0
            while ((mark & data[i]) != 0) {
                mark >>= 1;
                count ++;
            }
            i ++;
            int k = i + count - 1;

            // 如果count值为1，count值大于4或数组剩余长度小于字节数，则返回false
            if (count == 1 || count > 4 || k > data.length) return false;

            // 对在字节数内的后续字符进行遍历
            while (i < k) {

                // 判定对应字符是否满足10开头，不满足返回false
                if ((data[i] & 0x80) == 0 || (data[i] & 0x40) != 0)
                    return false;
                i ++;
            }
        }
        return true;
    }

    public boolean validUtf8_1(int[] data) {
        int n = 0;
        for(int i=0;i<data.length;i++){
            if(n>0){
                if(data[i]>>6!=2)return false;
                n--;
            }else if(data[i]>>7==0){
                n=0;
            }else if(data[i]>>5==0b110){
                n=1;
            }else if(data[i]>>4==0b1110){
                n=2;
            }else if(data[i]>>3==0b11110){
                n=3;
            }else{
                return false;
            }
        }
        return n==0;
    }
}