package _美团笔试;

import java.util.*;

public class Main {

    private static int max;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        if (n <= 2) {
            System.out.println(n -1);
        } else {

            solution(nums, n);
//            solution(nums, n );
            System.out.println(max);
        }

    }

    private static int solution(int[] nums, int len) {


        int[][] dp = new int[len][2];


        int left = 0, right = 0;
        for (int i = 1; i < len ; i++) {

            if (nums[i] > nums[i-1]) {
                dp[i][0] = Math.max(dp[i-1][0] + 1, dp[i-1][1] + 1);

            } else {
                dp[i][1] = dp[i][0];
                dp[i][0] = 1;

            }
        }
        return Math.max(dp[len-1][0] , dp[len -1][1]);
    }
}
