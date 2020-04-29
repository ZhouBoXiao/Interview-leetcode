package _公司笔试._招行._1;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] nums = new int[n][n];
        for (int i = 0 ; i < n; i ++) {
            for (int j =0 ; j <= i; j++) {
                nums[i][j] = scanner.nextInt();
            }
        }
        int[] dp = new int[n];
        for (int i = n - 1; i >=0; i--) {
            for (int j =0 ; j <=i; j++) {
                if (i == n-1) {
                    dp[j] = nums[i][j];
                } else {
                    dp[j] = Math.max(dp[j], dp[j+1]) + nums[i][j];
                }
            }
        }
        System.out.println(dp[0]);
    }
}
