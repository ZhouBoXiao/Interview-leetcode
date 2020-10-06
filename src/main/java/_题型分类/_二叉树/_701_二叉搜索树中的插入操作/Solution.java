package _题型分类._二叉树._701_二叉搜索树中的插入操作;

/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/9/18 21:41
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){val = x;}
}

public class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }

    public TreeNode insertIntoBST1(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode parent = root, p = root;
        while (p != null) {
            parent = p;
            p = p.val < val ? p.right : p.left;
        }
        if (parent.val < val) {
            parent.right = new TreeNode(val);

        } else {
            parent.left = new TreeNode(val);
        }
        return root;
    }

}
