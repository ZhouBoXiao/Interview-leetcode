package _题型分类._二叉树._687_最长同值路径;

/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/8/18 16:09
 */

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

public class Solution {
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return max;
    }
    int dfs(TreeNode root) {
        if (root.left == null && root.right == null) return 0;
        int leftSize = root.left != null ? dfs(root.left)  + 1 : 0;
        int rightSize = root.right != null ? dfs(root.right) + 1 : 0;

        if (leftSize > 0 && root.left.val != root.val) leftSize = 0;
        if (rightSize > 0 && root.right.val != root.val) rightSize = 0;
        max = Math.max(max, leftSize + rightSize);
        return Math.max(leftSize, rightSize);
    }
}
