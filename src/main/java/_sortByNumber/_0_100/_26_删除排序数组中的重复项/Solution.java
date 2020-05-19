package _sortByNumber._0_100._26_删除排序数组中的重复项;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/5 16:17
 */
public class Solution {

    public int removeDuplicates1(int[] nums) {
        // 使用双指针
        if (nums == null || nums.length == 1) {
            return nums.length;
        }
        int i = 0,j =1;
        while(j<nums.length){
            if(nums[i]==nums[j]){
                j++;
            }else{
                i++;
                nums[i]=nums[j];
                j++;
            }
        }
        return i+1;
    }
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int index = 0;int cur = 0;
        int pre = 0;
        index++;
        while (cur < nums.length - 1) {
            cur = right_bound(nums, nums[cur]);
            if (cur+1 < nums.length) {
                cur++;
                if (nums[pre] != nums[cur]) {
                    nums[index++] = nums[cur];
                    pre = cur;
                }
//                cur = right_bound(nums, nums[cur]) + 1;
            }
        }
        return index;
    }

    public int right_bound(int[] nums, int target) {
        int left = 0 , right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) /2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (right < 0 || nums[right] != target)
            return -1;
        return right;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(new Solution().removeDuplicates(nums));
    }
}
