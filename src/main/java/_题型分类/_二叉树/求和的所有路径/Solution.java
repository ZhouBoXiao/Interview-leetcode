package _题型分类._二叉树.求和的所有路径;

/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/9/17 23:38
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}


public class Solution {
    int res = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int dep = depth(root);
        int[] paths = new int[dep];

        helper(root, sum, paths, 0);
        return res;
    }
    private void helper(TreeNode node, int sum, int[] paths, int level) {
        if (node == null){
            return ;
        }
        paths[level] = node.val;
        int t = 0;
        for (int i = level; i >= 0; i--) {
            t += paths[i];
            if (t == sum) {
                res++;
            }
        }
        helper(node.left, sum, paths, level + 1);
        helper(node.right, sum, paths, level + 1);
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
