package 面试相关._合并两个有序数组;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/14 23:22
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2.length == 0) return ;
        int index = m - 1;
        for (int i =  nums1.length - 1 ; i >= nums1.length - m; i--) {
            nums1[i] = nums1[index--];
        }
        int k = 0;
        for (int i = nums1.length - m, j = 0; i < nums1.length ||  j < n; ) {
            if (i >= nums1.length ) {
                nums1[k++] = nums2[j++];
                continue;
            }
            if (j >= n) {
                nums1[k++] = nums1[i++];
                continue;
            }
            if (nums1[i] <= nums2[j]) {
                nums1[k++] = nums1[i++];
            } else if (nums1[i] > nums2[j]){
                nums1[k++] = nums2[j++];
            }
        }
    }

    public static void main(String[] args) {
        new Solution().merge(new int[]{1,2,4,5,6,0}, 5, new int[]{3}, 1);
    }
}