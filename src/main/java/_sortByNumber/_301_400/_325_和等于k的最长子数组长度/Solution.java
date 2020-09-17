package _sortByNumber._301_400._325_和等于k的最长子数组长度;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/9/11 16:21
 */
public class Solution {
    int maxSubArrayLen(int[] nums, int k) {
        //利用前缀和数组 快速计算子数组的和
        //而又因为求的是最长子数组等于k，所以我们在哈希表中保存的是前缀和为x第一次出现的下标
        //值为x的前缀和最早出现的下标y  hash【x】=y

        Map<Integer, Integer> map = new HashMap<>();
        // 这个初始化很重要，为了考虑到 0~i等于k的情况
        map.put(0, -1);
        int sum = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) res = Math.max(res, i - map.get(sum - k));
            if (!map.containsKey(sum)) map.put(sum, i);
        }
        return res;

    }
}
