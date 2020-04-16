package _DFS._打家劫舍3;

import java.util.*;

/**
 * 337
 */
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public int rob(TreeNode root) {
        int[] result = robInternal(root);
        return Math.max(result[0], result[1]);
    }
    public int[] robInternal(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] res = new int[2];
        int[] left = robInternal(root.left);
        int[] right = robInternal(root.right);

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = left[0] + right[0] + root.val;
        return res;
    }

}
