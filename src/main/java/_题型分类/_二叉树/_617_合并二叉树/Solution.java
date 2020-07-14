package _题型分类._二叉树._617_合并二叉树;

/**
 * @Description:
 * @Author:boxiao
 * @Date: 2020/7/12 15:57
 */

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public TreeNode mergeTrees1(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees1(t1.left, t2.left);
        t1.right = mergeTrees1(t1.right, t2.right);
        return t1;
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        TreeNode root = new TreeNode((t1==null ? 0 : t1.val) + (t2==null ? 0 : t2.val));
        root.left = mergeTrees(t1==null ? null : t1.left, t2==null ? null : t2.left);
        root.right = mergeTrees(t1==null ? null : t1.right, t2==null ? null : t2.right);
        return root;
    }
}
