package _公司笔试.leetcode._188周赛._1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/10 10:21
 */
public class Solution {
    public List<String> buildArray(int[] target, int n) {
        String push = "Push";
        String pop = "Pop";
        List<String> res = new ArrayList<>();
        int index = 1;
        for (int i = 0; i < target.length && index <= n; ) {
            if (target[i] != index) {
                res.add(push);
                res.add(pop);
                index++;
            } else {
                index++;
                i++;
                res.add(push);

            }

        }
//        while (index <= n) {
//            res.add(push);
//            res.add(pop);
//            index++;
//        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().buildArray(new int[]{1,2}, 4));
    }
}
