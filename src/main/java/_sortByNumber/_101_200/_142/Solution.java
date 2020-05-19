package _sortByNumber._101_200._142;

class ListNode {

    int val;
    ListNode next;
    ListNode(int x) {val = x; next = null;}
}

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return head;
        ListNode p1 = head, p2 = head;
        boolean hasCycle = false;
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                hasCycle = true;
                break;
            }
        }
        if (hasCycle) {
            ListNode p3 = head;
            while (p3 != p1) {
                p3 = p3.next;
                p1 = p1.next;
            }
            return p3;
        } else
            return null;

    }
}
