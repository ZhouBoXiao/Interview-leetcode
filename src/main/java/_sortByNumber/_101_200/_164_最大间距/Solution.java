package _sortByNumber._101_200._164_最大间距;

/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/8/9 20:30
 */
public class Solution {
    class Bucket{
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
    }
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        int max = 0, min = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int n = nums.length;
        /**
         *  假设x为(1， x]
         *  (x - 1) * (n - 1) < max - min
         *   x < (max - min) / (n - 1)
         */
        int bucketSize = Math.max((max - min)/(n - 1), 1);
        Bucket[] buckets = new Bucket[(max - min) / bucketSize + 1];
        for (int i = 0; i < n; i++) {
            int idx = (nums[i] - min)/ bucketSize;
            if (buckets[idx] == null) buckets[idx] = new Bucket();
            buckets[idx].min = Math.min(buckets[idx].min, nums[i]);
            buckets[idx].max = Math.max(buckets[idx].max, nums[i]);
        }
        int preMax = -1;
        int maxGap = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null && preMax != -1) {
                maxGap =  Math.max(maxGap, buckets[i].min - preMax);
            }
            if (buckets[i] != null) {
                preMax = buckets[i].max;
            }
        }
        return maxGap;
    }
}
