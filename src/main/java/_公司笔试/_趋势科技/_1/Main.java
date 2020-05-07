package _公司笔试._趋势科技._1;


import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/7 19:25
 */
public class Main {


    public static int findIndex(List<Integer> result,int v){
        int index = 0;
        for(Integer tmp : result){
            if(tmp == v){
                return index;
            }else{
                index++;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int start = 0;
        int dk = 1;
        int len = k;
        List<Integer> list = new LinkedList<>();
        for(int i = 1 ;i <= k; i++){
            list.add(i);
        }
        for(int i = 1 ;i <= k-1 ;i++){
            int dz = (start+dk)%len;
            int value = list.get((dz+1)%len);
            list.remove(dz);
            dk++;
            len--;
            start = findIndex(list,value);
        }
        System.out.println(list.get(0));

    }
}
