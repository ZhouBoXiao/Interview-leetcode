package _501_600._572_另一个树的子树;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/7 22:10
 */

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {val = x;}
}
public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        return subFrom(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);

    }
    public boolean subFrom(TreeNode s, TreeNode t){
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return subFrom(s.left, t.left) && subFrom(s.right, t.right);
    }
}
