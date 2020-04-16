
package 面试相关._二叉树._后序遍历二叉树;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}



public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {

            if(p != null) {
                stack.push(p);
                result.addFirst(p.val);
                p = p.right;
            } else {

                TreeNode node = stack.pop();
                p = node.left;
            }
        }
        return result;
    }
}
