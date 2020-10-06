package _题型分类._二叉树.有序链表转换二叉搜索树;

/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/9/17 23:40
 */

class ListNode {

    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        else if (head.next  == null) return new TreeNode(head.val);
        ListNode pre = head;
        ListNode p = pre.next;
        ListNode q = p.next;

        while (q != null && q.next != null) {
            pre = pre.next;
            p = pre.next;
            q = q.next.next;
        }
        pre.next = null;
        TreeNode root = new TreeNode(p.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(p.next);
        return root;
    }
}
