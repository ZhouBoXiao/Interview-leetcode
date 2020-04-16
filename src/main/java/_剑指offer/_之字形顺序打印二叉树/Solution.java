package _剑指offer._之字形顺序打印二叉树;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int v) {val = v;}
}

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> s1 = new ArrayDeque<>();
        Deque<TreeNode> s2 = new ArrayDeque<>();
        if (root == null) return res;
        s1.add(root);
        boolean flag = true;
        while (!s1.isEmpty() || !s2.isEmpty()) {

            List<Integer> tmp  = new ArrayList<>();
            if (flag) {
                int size = s1.size();
                while (size-- > 0) {
                    TreeNode node = s1.pop();
                    tmp.add(node.val);

                    if (node.left != null) {
                        s2.push(node.left);
                    }
                    if (node.right != null) {
                        s2.push(node.right);

                    }
                }

                flag = false;
            } else {
                int size = s2.size();
                while (size-- > 0) {
                    TreeNode node = s2.pop();
                    tmp.add(node.val);

                    if (node.right != null) {
                        s1.push(node.right);
                    }
                    if (node.left != null) {
                        s1.push(node.left);

                    }
                }


                flag = true;
            }
            res.add(tmp);
        }
        return res;
    }
}
