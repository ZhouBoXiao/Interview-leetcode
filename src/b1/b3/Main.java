package b1.b3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
            new Main().solution();
    }



    void solution() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int L= scanner.nextInt();
        int[][] a1 = new int[n][2];
        for (int i =0 ; i < n ; i++){
            a1[i][0] = scanner.nextInt();
            a1[i][1] = scanner.nextInt();
        }
        Arrays.sort(a1, (o1, o2) -> {

            if (o1[0]==o2[0]) return o1[1]-o2[1];
            return o1[0]-o2[0];
        });

        int ok = 1;
        int cnt = 0;
        int k = 0;
        int left = 0;
        int right = 0 ;
        int i = 0 ;
        while(left < L) {
            if (a1[k][0] > left) {
                ok = 0;
                break;
            }
            for (i = k; i < n; i++) {
                if (a1[i][0] <= left) {
                    right = Math.max(right, a1[i][1]);
                } else {
                    cnt++;
                    left = right;
                    k = i;
                    break;
                }

            }
            if (i == n) {
                cnt++;
                break;
            }
        }
        if (ok==1){
            System.out.println(cnt);
        }else{
            System.out.println(-1);
        }

    }
}