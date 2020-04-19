package _公司笔试._京东._2;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        /**
         * 将所有的事件 (到达或离开)按时间顺序排序，然后只记录当前还在车站（未离开的）列车。
         * 所有时间点中最多数量列车即待求解的答案。
         */
        while (in.hasNext()){
            int t = in.nextInt();
            int[] start = new int[t];
            int[] end = new int[t];
            for(int i=0;i<t;i++){
                start[i] = in.nextInt();
                //set.add(in.nextInt());
                end[i] = in.nextInt();
            }
            int count = 0;
            for(int i=0;i<t;i++){
                int temp = 0;
                for (int j=0;j<t;j++){
                    if(i==j){
                        continue;
                    }else {
                        if((start[j] >= start[i] && start[j] <= end[i]) || (end[j]>=start[i]&&end[j]<end[i])){
                            temp++;
                        }
                    }
                    count = Math.max(count,temp);
                }
            }
            System.out.println(count+1);
        }
    }
}
/*
10
84 302
275 327
364 538
26 364
29 386
545 955
715 965
404 415
903 942
150 402
 */