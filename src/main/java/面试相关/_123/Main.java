package 面试相关._123;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/15 16:10
 */
public class Main {

    static void solve(int[][] nums) {
        int n = nums.length;
        int max= 0, len = 0;
        for (int i =0 ; i < nums[0].length; i++) {
           // len = Math.min(len, nums[0][i].length);
            max+=nums[0][i];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < max ; i++) {
            int cnt = 0;
            for (int j = 0; j < nums.length; j++) {
                int k = 0 , sum = 0;
                for (; k < nums[j].length; k++) {
                    sum+=nums[j][k];
                    if (sum > i ){
                        cnt++;
                        break;
                    }
                    if (sum == i) {
                        break;
                    }
                }
            }

            min = Math.min(min, cnt);
        }
        System.out.println(min);
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1,2,2,1},
                {1,1,4},
                {1,3,2}
        };
        solve(nums);
    }
}
