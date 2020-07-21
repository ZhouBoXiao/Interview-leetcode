package _sortByNumber._201_300._300;

public class Solution {

    void solve1() {
        int[] nums = new int[0], dp = new int[0];
        int n = nums.length;
        int len = 0;
        for (int i = 0; i < n; i++) {
            int left = 0, right = len - 1;
            while (left < right) {
                int mid = left + (right - left)/2;
                if (dp[mid] < nums[i]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            dp[left] = nums[i];
            if (left == len) {
                len++;
            }
        }
        System.out.println(len);

    }

    /**
     * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
     *
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS1(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        /**
         * dp[i]: 所有长度为i+1的递增子序列中, 最小的那个序列尾数.
         * 由定义知dp数组必然是一个递增数组, 可以用 maxL 来表示最长递增子序列的长度.
         * 对数组进行迭代, 依次判断每个数num将其插入dp数组相应的位置:
         * 1. num > dp[maxL], 表示num比所有已知递增序列的尾数都大, 将num添加入dp
         *    数组尾部, 并将最长递增序列长度maxL加1
         * 2. dp[i-1] < num <= dp[i], 只更新相应的dp[i]
         *
         *
         * dp[i] 所有长度为i+1的递增子序列中，最小的那个序列尾数
         */
        int[] dp = new int[n];
        int len = 0;
        for (int i = 0; i < n; i++) {

            int left = 0, right = len;

            while (left < right) {
                int mid = left + ((right - left) >>> 1);
                if (nums[i] > dp[mid]) {
                    left = mid + 1;
                } else{
                    right = mid;
                }

            }

            dp[left] = nums[i];
            if (left == len) {
                len++;
            }
        }
        return len;

    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int len = 0;

        for (int i = 0 ; i < nums.length; i++) {
//            Arrays.binarySearch()
            int left = 0 , right = len - 1;
            while (left <= right) {
                int mid = left + (right - left)/ 2;
                if (dp[mid] < nums[i]) {
                    left = mid +1;
                } else {
                    right = mid - 1;
                }
            }
            dp[left] = nums[i];
            if (left == len) {
                len++;
            }

        }
        return len;
    }

    public static void main(String[] args) {
        //10,9,2,5,3,7,101,18

        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(new Solution().lengthOfLIS(nums));
    }
}
