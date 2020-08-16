package _sortByNumber._201_300._215;

public class Solution {


    /**
     * 解法二： 建小顶堆
     */
    int findKthLargest(int[] nums, int k){
        for (int i = k/2 - 1; i >= 0; i--) {
            heap(nums, i, k);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[0] < nums[i])
                nums[0] = nums[i];
            heap(nums, 0, k);
        }

        return nums[0];
    }
    
    private void heap(int[] nums, int pos, int length) {
        int temp = nums[pos];
        for (int i = 2*pos + 1; i < length; i = 2*i + 1) {
            if ( i + 1 < length && nums[i] > nums[i + 1]) {
                i++;
            }
            if (nums[i] < temp) {

                nums[pos] = nums[i];
                pos = i;
            } else {
                break;
            }
        }
        nums[pos] = temp;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        new Solution().findKthLargest(nums, 4);
    }


    /**
     * 解法一：利用快排
     * @param args
     */
    public int findKthLargest1(int[] nums, int k){
        // k是要求的第几大(从1开始计数),k-1即是数组中的序号(0开始计数)
        return findKthLargest(nums,0,nums.length-1,k-1);
    }
    public int findKthLargest(int[] nums,int low,int high,int k){
        int index = partition(nums,low,high);
        if (index == k)
            return nums[index];
        else if (index>k)
            return findKthLargest(nums,low,index-1,k);
        else
            return findKthLargest(nums,index+1,high,k);
    }

    // 同快排的partation,每次确定一个枢轴的位置,并返回其index
    // 找第k 大 的数就把数组按大->小排列
    private int partition(int[] nums,int left,int right){
        int temp = left;
        while (left < right){
            while (left < right && nums[right] >= nums[temp]) right--;
            while (left < right && nums[left] <= nums[temp]) left++;
            swap(nums, left, right);
        }
        swap(nums, temp, right);
        return right;
    }

    void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
