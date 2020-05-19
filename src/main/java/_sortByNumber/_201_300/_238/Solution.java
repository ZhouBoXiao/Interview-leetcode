package _sortByNumber._201_300._238;

import java.util.Arrays;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);
        int left = 1, right = 1;
        for (int i = 1; i < nums.length ; i++) {
            left *= nums[i - 1];
            res[i] *= left;
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            right *= nums[i + 1];
            res[i] *= right;
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().productExceptSelf(new int[]{1,2,3,4});
    }
}
