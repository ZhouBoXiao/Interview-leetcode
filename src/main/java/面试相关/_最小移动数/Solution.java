package 面试相关._最小移动数;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int k = (nums.length + 1) / 2;
        int ans = 0;
        for (int i = 0 ; i < nums.length; i++) {
            ans += Math.abs(nums[i] - nums[k]);
        }
        return ans;
    }

    public int minMoves1(int[] nums) {
        int k = (nums.length + 1) / 2;
        int num = getKth(nums,0, nums.length - 1, k-1 );
        int ans = 0;
        for (int i = 0 ; i < nums.length; i++) {
            ans += Math.abs(nums[i] - num);
        }
        return ans;
    }
    int getKth(int[] nums, int left, int right, int k) {

        int mid = partition(nums, left, right);
        if (mid == k) return nums[mid];
        else if (mid > k) {
            return getKth(nums, left, mid -1 , k);
        } else  {
            return getKth(nums, mid +1 , right, k );
        }
    }
    int partition(int[] nums, int left, int right) {

        int temp = left;
        while (left < right) {

            while (left<right && nums[temp] <= nums[right]) right--;
            while (left<right && nums[temp] >= nums[left]) left++;
            swap(nums,left,right);
        }
        swap(nums,temp,right );
        return right;
    }
    void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


}
//26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41
//[10,27,10,35,12,22,28,8,19,2,12,2,9,6,12,5,17,9,19,12,14,6,12,5,12,3,0,10,0,7,8,4,0,0,4,3,2,0,1,0]