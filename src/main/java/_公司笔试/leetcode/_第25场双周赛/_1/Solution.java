package _公司笔试.leetcode._第25场双周赛._1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/2 22:31
 */
public class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();
        for (int i = 0; i < candies.length ; i++) {
            int tmp = candies[i] + extraCandies;
            int j = 0;
            for (j =  0 ; j < candies.length; j++) {
                if (tmp < candies[j]) {
                    list.add(false);
                    break;
                }
            }
            if (j == candies.length )
                list.add(true);
        }
        return list;
    }

    public static void main(String[] args) {
        new Solution().kidsWithCandies(new int[]{12,1,12}, 10);
    }
}
