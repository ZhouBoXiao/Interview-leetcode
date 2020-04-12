package _链表._翻转链表;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    /** 反转区间 [a, b) 的元素，注意是左闭右开 */
    ListNode reverse(ListNode a, ListNode b) {
        ListNode next ;
        ListNode pre = null;
        ListNode cur = a;
        while (cur != b) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode a, b;
        // 区间 [a, b) 包含 k 个待反转元素
        a = b = head;
        // 不足 k 个，不需要反转，base case
        for (int i = 0 ; i <k; i++) {
            if (b == null) return head;
            b = b.next;
        }
        ListNode newHead  = reverse(a, b);
        // 递归反转后续链表并连接起来
        a.next = reverseKGroup(b, k);
        return newHead ;
    }
}
