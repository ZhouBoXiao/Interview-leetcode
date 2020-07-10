package _sortByNumber._0_100._31_下一个排列;

import java.util.Arrays;

/**
 * @Description: 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * @Author:boxiao
 * @Data: 2020/5/11 22:53
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = len - 1; j > i; j--) {
                if (nums[i] < nums[j]){
                    swap(nums,i,j);
                    reverse(nums,i+1,len-1);
                    return;
                }
            }
        }
        reverse(nums,0,len-1);

    }

    private void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int lo, int hi){
        while(lo < hi){
            swap(nums, lo++, hi--);
        }
    }
    /*public void nextPermutation(int[] nums) {
        int n = nums.length;
        for (int i = n - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                int j = n - 1;
                for (; j > 0; j--) {
                    if (nums[j] > nums[i - 1]) {
                        swap(nums, i - 1, j);
                        break;
                    }
                }
                Arrays.sort(nums, i, n);
                return;
            }
        }
        Arrays.sort(nums);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }*/
}
