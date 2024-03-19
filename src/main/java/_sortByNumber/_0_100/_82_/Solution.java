package _sortByNumber._0_100._82_;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode cur = h;
        while (h.next != null && h.next.next != null) {
            int val = h.next.val;
            if (val == h.next.next.val) {
                while (h.next != null && val == h.next.val) {
                    h.next = h.next.next;
                }
            } else {
                h = h.next;
            }
        }
        return cur.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p1 = new ListNode(2);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);
        ListNode p5 = new ListNode(4);
        ListNode p6 = new ListNode(5);
        head.next = p1; p1.next = p2;  p2.next = p3; p3.next = p4; p4.next = p5; p5.next = p6;
        new Solution().deleteDuplicates(head);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
}