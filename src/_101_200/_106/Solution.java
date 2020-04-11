package _101_200._106;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

/**
 * 从中序与后序遍历序列构造二叉树
 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0 , postorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] inorder, int in_start, int in_end, int[] postorder, int post_start, int post_end) {
        if (in_start > in_end || post_start > post_end)
            return null;
        TreeNode root = new TreeNode(postorder[post_end]);
        for (int i = in_start; i <= in_end; i++) {
            if (inorder[i] == postorder[post_end]) {
                root.left =  buildTreeHelper(inorder, in_start, i - 1, postorder, post_start, post_start + i - in_start - 1);
                root.right =  buildTreeHelper(inorder, i + 1, in_end, postorder, post_start + i - in_start, post_end - 1);
                break;
            }
        }
        return root;

    }
}
