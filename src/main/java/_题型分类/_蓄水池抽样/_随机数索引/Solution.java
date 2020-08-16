package _题型分类._蓄水池抽样._随机数索引;

import java.util.Random;

/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/8/11 11:27
 */
public class Solution {

    int[] res;
    public Solution(int[] nums) {
        res = nums;
    }

    public int pick(int target) {

        Random r = new Random();
        int cnt = 0 ;
        int index  =0 ;
        for (int i = 0; i < res.length; i++) {
            if (res[i] == target) {
                cnt++;
                //我们以1/n的概率留下该数据
                if (r.nextInt() % cnt == 0) {
                    index = i;
                }
            }
        }
        return index;
    }
}
