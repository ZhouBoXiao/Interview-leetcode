import java.util.ArrayList;
import java.util.List;

/**
 *
 * 有1、2、3、4个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/29 16:37
 */
public class Solution1 {
    List<Integer> solve(int[] nums) {
        List<Integer> res = new ArrayList<>();
        boolean[] vis  = new boolean[nums.length];

        dfs(res,0, 0, nums);
        System.out.println(res.size());
        System.out.println(res);
        return res;
    }

    void dfs(List<Integer> res,  int sum, int cur, int[] nums) {
        if (cur == 3) {
            res.add(sum);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            dfs(res, sum * 10 + nums[i], cur+1, nums);
        }

    }

    public static void main(String[] args) {
        new Solution1().solve(new int[]{1,2,3,4});
    }
}
