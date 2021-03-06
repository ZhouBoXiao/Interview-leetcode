package _题型分类._链表._109_有序链表转换二叉搜索树;

/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/8/10 20:22
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        else if (head.next  == null) return new TreeNode(head.val);
        int n = 0;
        for (ListNode p = head; p != null; p = p.next) {
            n++;
        }
        ListNode cur = head;
        for (int i = 0; i < n / 2 - 1;i ++) cur = cur.next;
        TreeNode root = new TreeNode(cur.next.val);
        root.right = sortedListToBST(cur.next.next);
        cur.next = null;
        root.left = sortedListToBST(head);
        return root;
    }


    public TreeNode sortedListToBST1(ListNode head) {
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
