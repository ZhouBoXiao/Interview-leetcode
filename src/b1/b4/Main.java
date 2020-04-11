package b1.b4;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        new Main().solution();
    }
    void solution() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0 ; i < n ; i++){
            a[i] = scanner.nextInt();

        }
        int[][] dp = new int[n+1][3];
        for (int i = 0 ; i < n ; i++){
            b[i] = scanner.nextInt();
            Arrays.fill(dp[i], 0x3f);
        }
        dp[0][0] = 1;
        if (a[0]==1 ) dp[0][1] = 0;
        if (b[0]==1 ) dp[0][2] = 0;

        for (int i =1; i < n ; i++){

                if (a[i] == 1) {
                    if (b[i-1] == 1)
                        dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]);
                    else{
                        dp[i][1] = dp[i-1][0];
                    }
                }else{
                    dp[i][1] = n;
                }
                if (b[i] == 1) {
                    if (a[i-1] == 1)
                        dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]);
                    else
                        dp[i][2] = dp[i-1][0];
                }else{
                    dp[i][2] = n;
                }
                dp[i][0] = Math.min(dp[i-1][0], Math.min(dp[i-1][1], dp[i-1][2])) + 1;


        }
        System.out.println(Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2])));
    }

}
