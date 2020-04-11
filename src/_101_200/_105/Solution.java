package _101_200._105;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

/**
 * 从前序与中序遍历序列构造二叉树
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        for (int i = inStart; i <= inEnd ; i++) {
            if (inorder[i] == preorder[preStart]) {
                root.left = buildTreeHelper(preorder, preStart + 1, preStart+i-inStart, inorder, inStart, i - 1);
                root.right = buildTreeHelper(preorder, preStart+i-inStart+1, preEnd, inorder, i+1, inEnd);
                break;
            }
        }
        return root;
    }
}
