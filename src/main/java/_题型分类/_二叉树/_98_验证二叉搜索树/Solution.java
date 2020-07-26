package _题型分类._二叉树._98_验证二叉搜索树;

import java.util.concurrent.atomic.AtomicInteger;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    AtomicInteger atomicInteger = new AtomicInteger();
    TreeNode(int x) {val = x;

    }
}

public class Solution {

    public boolean isValidBST(TreeNode root) {
        return helper(root,null,null);
    }
    public boolean helper(TreeNode root,Integer lower,Integer upper) {
        if (root == null) {
            return true;
        }
        int val = root.val;
        if(upper != null && val >= upper) return false;
        if(lower != null && val <= lower) return false;

        if(!helper(root.left,lower,val)) return false;
        if(!helper(root.right,val,upper)) return false;
        return true;

    }

}
