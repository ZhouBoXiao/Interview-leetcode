package _网易._2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(),D = in.nextInt();
        int[][] arr = new int[n][2];
        for(int i = 0;i < n;i++) arr[i][0] = in.nextInt();
        for(int i = 0;i < n;i++) arr[i][1] = in.nextInt();
        Arrays.sort(arr,(a,b) -> {
            if(a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        long res = 0;
        int l = 0,r = n - 1;
        while(l <= r){
            if(D > arr[l][0]){
                D++;
                l++;
            }else{
                res += arr[r][1];
                D++;
                r--;
            }
        }
        System.out.println(res);
    }
}
