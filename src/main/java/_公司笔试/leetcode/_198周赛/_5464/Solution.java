package _公司笔试.leetcode._198周赛._5464;

/**
 * @Description:小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。
 *
 * 如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。
 *
 * 请你计算 最多 能喝到多少瓶酒。
     * @Author:zhouboxiao@rd.netease.com
 * @Date: 2020/7/19 12:56
 */
public class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles;
        int empty = numBottles;
        while (empty >= numExchange) {
            res += empty  / numExchange;
            empty = empty % numExchange + empty  / numExchange;
        }
        return res;
    }
}
