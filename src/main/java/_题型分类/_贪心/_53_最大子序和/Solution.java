package _题型分类._贪心._53_最大子序和;

import java.util.Optional;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/2 13:30
 */
public class Solution {
    public int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int preSum = nums[0];
        int maxSum = preSum;
        for (int i = 1; i < nums.length; i++) {
            preSum = preSum > 0 ? preSum + nums[i] : nums[i];
            maxSum = Math.max(maxSum, preSum);
        }
        return maxSum;
    }
    public int maxSubArray(int[] nums) {
        //类似寻找最大最小值的题目，初始值一定要定义成理论上的最小最大值
        int result = -1;
        int numsSize = nums.length;
        result = maxSubArrayHelper(nums, 0, numsSize - 1);
        return result;

    }
    int maxSubArrayHelper(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = (left + right) / 2;
        int leftSum = maxSubArrayHelper(nums, left, mid);
        //注意这里应是mid + 1，否则left + 1 = right时，会无线循环
        int rightSum = maxSubArrayHelper(nums, mid + 1, right);
        int midSum = findMaxCrossingSubarray(nums, left, mid, right);
        int result = Math.max(leftSum, rightSum);
        result = Math.max(result, midSum);
        return result;
    }

    int findMaxCrossingSubarray(int[] nums, int left, int mid, int right)
    {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= left; i--)
        {
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }

        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        //注意这里i = mid + 1，避免重复用到nums[i]
        for (int i = mid + 1; i <= right; i++)
        {
            sum += nums[i];
            rightSum = Math.max(rightSum, sum);
        }
        return (leftSum + rightSum);
    }

    public static void main(String[] args) {
        Optional.of(new Solution().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4})).ifPresent(System.out::println);
    }

}
