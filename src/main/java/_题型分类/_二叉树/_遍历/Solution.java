package _题型分类._二叉树._遍历;

import java.util.*;

/**
 * @Description:
 * @Author:zhouboxiao@rd.netease.com
 * @Date: 2020/7/17 18:38
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                res.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                cur = cur.right;
            }
        }
        return res;
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                res.addFirst(cur.val);
                cur = cur.right;
            } else {
                cur = stack.pop();
                cur = cur.left;
            }
        }
        return res;
    }
    //自下而上分层遍历
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return res;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> temp = new LinkedList<>();
            while (count-- > 0) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(0, temp);
        }
        return res;
    }
    //按之字形顺序打印二叉树
    public List<List<Integer>> Print(TreeNode pRoot) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        int flag = 1;
        if (pRoot == null) {
            return res;
        }
        s2.push(pRoot);
        List<Integer> temp = new ArrayList<>();
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (flag % 2 != 0) {
                while (!s2.isEmpty()) {
                    TreeNode node = s2.pop();
                    temp.add(node.val);
                    if (node.left != null) {
                        s1.push(node.left);
                    }
                    if (node.right != null) {
                        s1.push(node.right);
                    }
                }
            } else {
                while (!s1.isEmpty()) {
                    TreeNode node = s1.pop();
                    temp.add(node.val);

                    if (node.right != null) {
                        s2.push(node.right);
                    }
                    if (node.left != null) {
                        s2.push(node.left);
                    }
                }
            }
            res.add(new ArrayList<>(temp));
            temp.clear();
            flag = 1 - flag;
        }
        return res;
    }
}
