package _公司笔试._酷家乐._1;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/26 17:29
 */
public class Solution {
    public int solve(int[] nums) {
        if (nums.length == 0 ) return -1;
        int maj = nums[0] ;
        int cnt = 1;
        for (int i = 1 ; i < nums.length; i++ ) {
            cnt = maj == nums[i] ? cnt + 1 : cnt - 1;
            if ( cnt == 0 ) {
                maj = nums[i];
                cnt = 1;
            }
        }
        cnt = 0;
        for (int i = 0 ; i < nums.length; i++ ) {
            if ( nums[i] == maj) {
                cnt++;
            }
        }
        return cnt > nums.length/2 ? maj : -1;
    }
}
