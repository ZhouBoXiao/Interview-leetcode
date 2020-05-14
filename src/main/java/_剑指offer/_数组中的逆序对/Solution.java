package _剑指offer._数组中的逆序对;

import java.util.concurrent.atomic.AtomicInteger;

public class Solution {
    // 后有序数组中元素出列的时候，计算逆序个数

    public int reversePairs(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return 0;
        }
        int[] temp = new int[len];
        return reversePairs(nums, 0, len - 1, temp);
    }

    /**
     * 计算在数组 nums 的索引区间 [left, right] 内统计逆序对
     *
     * @param nums  待统计的数组
     * @param left  待统计数组的左边界，可以取到
     * @param right 待统计数组的右边界，可以取到
     * @return
     */
    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        // 极端情况下，就是只有 1 个元素的时候，这里只要写 == 就可以了，不必写大于
        if (left == right) {
            return 0;
        }

        int mid = (left + right) >>> 1;

        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid + 1, right, temp);

        int reversePairs = leftPairs + rightPairs;
        if (nums[mid] <= nums[mid + 1]) {
            return reversePairs;
        }

        int reverseCrossPairs = mergeAndCount(nums, left, mid, right, temp);
        return reversePairs + reverseCrossPairs;

    }

    /**
     * [left, mid] 有序，[mid + 1, right] 有序
     * @param nums
     * @param left
     * @param mid
     * @param right
     * @param temp
     * @return
     */
    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        // 复制到辅助数组里，帮助我们完成统计
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid + 1;
        int res = 0;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                // i 用完了，只能用 j
                nums[k] = temp[j];
                j++;
            } else if (j > right) {
                // j 用完了，只能用 i
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                // 此时前数组元素出列，不统计逆序对
                nums[k] = temp[i];
                i++;
            } else {
                // 此时后数组元素出列，统计逆序对，快就快在这里，一次可以统计出一个区间的个数的逆序对
                nums[k] = temp[j];
                j++;
                res += (mid - i + 1);
            }
        }
        return res;
    }


}
class Solution1 {

    private long cnt = 0;
    private int[] tmp;  // 在这里声明辅助数组，而不是在 merge() 递归函数中声明
    public int reversePairs(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return (int) cnt;
    }
    void mergeSort(int[] nums, int l , int h) {
        if (l >= h) return;
        int m = l + (h - l )/2;
        mergeSort(nums, l , m);
        mergeSort(nums, m+1, h);
        merge(nums, l, m , h);

    }

    void merge(int[] nums,int l, int m , int h) {
        int i = l, j = m + 1, k = l;
        while (i <= m || j <= h) {
            if (i > m) {
                tmp[k] = nums[j++];
            } else if (j > h) {
                tmp[k] = nums[i++];
            } else if (nums[i] <= nums[j]) {
                tmp[k] = nums[i++];
            } else if (nums[i] > nums[j]) {
                tmp[k] = nums[j++];
                cnt += m - i + 1;
            }
            k++;
        }
        for (k = l; k <= h; k++) {
            nums[k] = tmp[k];
        }
    }
}