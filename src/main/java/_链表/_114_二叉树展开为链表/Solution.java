package _链表._114_二叉树展开为链表;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/18 23:17
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
}
public class Solution {
    TreeNode last;
    public void flatten(TreeNode root) {
        if (root==null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = last;
        root.left = null;
        last = root;
    }
}
