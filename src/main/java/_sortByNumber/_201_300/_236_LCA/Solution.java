package _sortByNumber._201_300._236_LCA;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/10 10:17
 */

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {val = x;}
}
public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (root.val == p.val || root.val == q.val ) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p , q);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        }
        return null;

    }
}
