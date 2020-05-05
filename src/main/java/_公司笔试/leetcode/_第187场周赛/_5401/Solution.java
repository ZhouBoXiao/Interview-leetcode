package _公司笔试.leetcode._第187场周赛._5401;

import javax.swing.plaf.basic.BasicSplitPaneUI;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/3 10:49
 */
public class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        if (k == 0 )    return true;
        int pre = -1;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0) {
                if (nums[i] == 1) {
                    if (i - pre - 1 < k) {
                        return false;
                    } else {
                        pre = i;
                    }
                }
            } else {
                if (nums[i] == 1)
                    pre = 0;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().kLengthApart(new int[]{0,1,0,1}, 1));
    }
}
