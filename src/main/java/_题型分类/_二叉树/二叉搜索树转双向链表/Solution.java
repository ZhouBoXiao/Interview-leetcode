package _题型分类._二叉树.二叉搜索树转双向链表;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/9/4 16:05
 */

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

public class Solution {
    Node pre = null, head = null;  //pre记录上一个节点，head为最后返回的头结点

    public Node treeToDoublyList(Node root) {
        if (root == null) return root;
        helper(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void helper(Node root) {
        if (root == null) return;
        helper(root.left);
        root.left = pre;
        if (pre != null) {
            pre.right = root;
        } else {
            head = root;
        }
        pre = root;
        helper(root.right);
    }

    public List<Integer> inorderTraversal(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (pre == null) {
                    head = cur;
                } else {
                    pre.right = cur;
                    cur.left = pre;
                    pre = cur;
                }
                cur = cur.right;
            }
        }
        return res;
    }

}
