package _公司笔试.leetcode._分割字符串的最大得分;

import java.util.*;
import java.util.stream.Collector;


/**
 * 5180. 带限制的子序列和
 * 给你一个整数数组 nums 和一个整数 k ，请你返回 非空 子序列元素和的最大值，子序列需要满足：子序列中每两个 相邻 的整数 nums[i] 和 nums[j] ，它们在原数组中的下标 i 和 j 满足 i < j 且 j - i <= k 。
 *
 * 数组的子序列定义为：将数组中的若干个数字删除（可以删除 0 个数字），剩下的数字按照原本的顺序排布。
 *
 *
 */
public class Solution {
    /**
     * dp[i] = max(nums[i], nums[i] + max(dp[j]/j = i - 1 .... i - k/))
     * 使用单调栈记录第i个数的前k个最大子序列和的单调递减栈, 以实O(1)的最大值查找。
     * 对于第i个数, 只需要前k个最大子序列和的记录, 故此处使用一个queue, 队满时(k + 1)弹出首个值。
     *
     * 时间复杂度: O(n) 一次遍历, 查找最大值与维护单调栈均为O(1)
     * 空间复杂度: O(k)
     */
    public int constrainedSubsetSum(int[] nums, int k) {
        int ans = Integer.MIN_VALUE, n = nums.length;
        //单调递减
        Deque<Integer> deque = new ArrayDeque<>();
        int[] dp = new int[n];
        for (int i = 0; i < n ; i++) {
            if (!deque.isEmpty() && i - deque.peekFirst() > k) {
                deque.pollFirst();
            }
            dp[i] = Math.max(0 , (deque.isEmpty() ? 0 : dp[deque.peekFirst()])) + nums[i];
            while (!deque.isEmpty() && dp[deque.peekLast()] < dp[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public int[] findDiagonalOrder(List<List<Integer>> nums) {

        Map<Integer, List<Integer>> map = new TreeMap<>();
        int len = 0;
        for (int i = nums.size() - 1 ; i>=0 ; i--) {
            len += nums.get(i).size();
            for (int j = 0; j < nums.get(i).size(); j++) {
                if (!map.containsKey(i+j)) {
                    map.put(i+j, new ArrayList<>());
                }
                map.get(i+j).add(nums.get(i).get(j));

            }
        }
        int[] ans = new int[len];
        int index = 0;
        for(int key : map.keySet()) { // 遍历map
            List<Integer> list = map.get(key);
            for(int j = 0;j < list.size();j++) { // 根据题目的输出要求确定生成数组中元素的顺序
                ans[index] = list.get(j);
                index++;
            }
        }
        return ans;
    }

    public int maxScore2(int[] cardPoints, int k) {

        int sum = 0, max = 0;
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }
        int n = cardPoints.length - 1;
        max = sum;
        for (int i = 0; i < k ; i ++) {

            sum -= cardPoints[k - i - 1];
            sum += cardPoints[n - i];
            max = Math.max(max, sum);
        }
        return max;

    }


    public static void main(String[] args) {
        System.out.println(new Solution().maxScore2(new int[]{1,2,3,4,5,6,1}, 3));
    }

    public int maxScore1(String s) {
        int c0 = 0, c1 = 0, ans = 0;
        for (char c : s.toCharArray()){
            if (c == '1') c1++;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') c0++;
            else if (s.charAt(i) == '1') c1--;
            ans = Math.max(ans, c0+c1);
        }
        return ans;
    }
}
/**
 [11,49,100,20,86,29,72]
 4
 [1,2,3,4,5,6,1]
 3
 int left = 0, right = cardPoints.length - 1;
 while(left<=right) {

 if (cardPoints[left] > cardPoints[right]) {
 if (k-- <= 0) break;
 max += cardPoints[left++];

 } else if (cardPoints[left] < cardPoints[right]) {
 if (k-- <= 0) break;
 max += cardPoints[right--];

 } else {
 //                max += cardPoints[right];
 //                left++; right--;
 int l = left + 1, r = right -1;
 boolean flag = false;
 while (l <= r) {

 if (cardPoints[l] > cardPoints[r]) {
 if (k-- <= 0) break;
 max += cardPoints[left++];
 flag = true;
 //                        while (++left <= l);
 break;
 } else if (cardPoints[l] < cardPoints[r]) {
 if (k-- <= 0) break;
 max += cardPoints[right--];
 //                        while (--right >= r);
 flag = true;
 break;
 } else {
 l++;r--;

 //                        if (k-- <= 0) break;
 //                        max += cardPoints[r];
 //                        left++; right--;
 }
 }
 if (!flag) {
 if (k-- <= 0) break;
 max += cardPoints[right--];
 }
 if (k <= 0) break;

 }
 }
 */