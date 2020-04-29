package _公司笔试.leetcode._节点与其祖先之间的最大差值;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/4/29 17:07
 */



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    int max = 0;
    public int maxAncestorDiff(TreeNode root) {
        maxAncestorDiff(root, root.left);
        maxAncestorDiff(root, root.right);
        if (root.left != null) {
            maxAncestorDiff(root.left);
        }
        if (root.right != null) {
            maxAncestorDiff(root.right);
        }
        return max;
    }

    private void maxAncestorDiff(TreeNode root, TreeNode node) {

        if (root == null || node == null) {
            return;
        }
        if (Math.abs(root.val - node.val) > max) {
            max = Math.abs(root.val - node.val);
        }

        maxAncestorDiff(root, node.left);
        maxAncestorDiff(root, node.right);

    }
}
