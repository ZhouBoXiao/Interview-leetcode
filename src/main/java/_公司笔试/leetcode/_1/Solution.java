package _公司笔试.leetcode._1;

import java.util.Arrays;
import java.util.*;

public class Solution {
    //int res = 0;
    public int[] getTriggerTime(int[][] increase, int[][] requirements) {

        int[] res = new int[requirements.length];
        Arrays.fill(res, -1);
        int[][] day = new int[increase.length + 1][3];
        for (int i = 1; i < increase.length; i++) {
            increase[i][0] += increase[i - 1][0];
            increase[i][1] += increase[i - 1][1];
            increase[i][2] += increase[i - 1][2];
        }
        System.arraycopy(increase, 0, day, 1, increase.length);

        for (int i = 0; i < requirements.length ; i++) {

            int j = left_bound(day, requirements[i]);
            if (j != -1) {
                res[i] = j;
            }
        }

        return res;
    }

    boolean ok (int[] a, int[] b) {
        if (a[0] >= b[0] && a[1] >= b[1] && a[2] >= b[2]) {
            return true;
        }
        return false;
    }

   //               increase  >= requirement
    int left_bound(int[][] nums, int[] target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left + 1) / 2 ;
            if (nums[mid][0] >= target[0]) {
                if (ok(nums[mid], target)) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid][0] < target[0]) {

                left = mid + 1;
            }

        }

        if (left >= nums.length || !ok(nums[left], target))
            return -1;
        return left;
    }

    public static void main(String[] args) {
        int[] cost = new int[]{13,12,9,12,15,11,10,11,15};
       // System.out.println(new Solution().largestNumber(cost, 52));
    }


//    public String largestNumber(int[] cost, int target) {
//        int[][] dp= new int[12][target+7];
//        Arrays.fill(dp, 0x8f);
//
//        dp[0][0] = 0;
//        for (int i = 1; i <= 9; ++i) {
//            for (int j = 0; j <= target; ++j) {
//                for (int k = 0; k*cost[i-1] <= j; ++k) {
//                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-k*cost[i-1]]+k);
//                }
//            }
//        }
//        int u = 0;
//        for (int i = 1; i <= 9; ++i) {
//            if (dp[i][target] >= dp[u][target]) u = i;
//        }
//        if (dp[u][target] <= 0) return "0";
//        String res;
//        for (int num = target, k; num >=0 && u>=0; --u) {
//            for (k = num/cost[u-1]; k >=0; --k) {
//                if (dp[u][num] == dp[u-1][num-k*cost[u-1]]+k) break;
//            }
//            for (int i = 0; i < k; ++i) res += String.valueOf(u);
//            // res += string(k, to_string(u));
//            num -= k*cost[u-1];
//        }
//        return res;
//    }



    private static int cnt =0 ;
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;

        ArrayList<Integer> result = new ArrayList<Integer>();
        cnt =0;
        preOrder(root, result);

        return cnt;
    }

    int work(TreeNode root,int m) {
        if(root==null) return 0;
        int s=0;
        if(m<=root.val) {
            m=root.val;
            s=1;
        }
        s+=work(root.left,m)+work(root.right,m);
        return s;
    }
    void preOrder(TreeNode root,ArrayList<Integer> result){
        boolean flag = true;
        result.add(root.val);
        for (int num : result) {
            if (num > root.val) {
                flag = false;
                break;
            }
        }
        if (flag) {
            cnt++;
        }
        if (root.left != null) {
            preOrder(root.left, result);
            result.remove(result.size()-1);
        }

        if (root.right != null) {
            preOrder(root.right, result);
            result.remove(result.size()-1);
        }
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
