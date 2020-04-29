package _公司笔试._招行._3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[n];
        int[] map = new int[10001];
        for (int i = 0 ; i < n; i ++) {
            nums[i] = scanner.nextInt();
            map[nums[i]]++;
            if (map[nums[i]] >= k) {
                System.out.println(0);
                return;
            }
        }
        Arrays.sort(nums);
        long[] sum = new long[n];
        sum[0] = nums[0];
        for (int i = 1 ;i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        ///取最前k个数
        long ans1 = (long) nums[k-1] * k -sum[k-1];
        int tmp = k;
        //向后扫描是否有一样的
        while (tmp < n && nums[tmp] == nums[k - 1]) {
            tmp++;
            ans1--;
        }
        //取最后k个数
        long ans2 = sum[n-1] - sum[n - k - 1] - (long) nums[n - k] *k;
        tmp = n - k - 1;
        //向前扫描是否有一样的
        while (tmp >= 0 && nums[tmp] == nums[n - k]) {
            tmp--;
            ans2--;
        }
        System.out.println(Math.min(ans1, ans2));
    }
}
