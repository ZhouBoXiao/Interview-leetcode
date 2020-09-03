package _sortByNumber._301_400._328_奇偶链表;

/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/9/3 12:51
 */

class ListNode {
    int val;
    ListNode next;
}


public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode o = head;
        ListNode p = head.next;
        ListNode e = p;
        while (o.next != null && e.next != null ) {
            o.next = e.next;
            o = o.next;
            e.next = o.next;
            e = e.next;
        }
        o.next = p;
        return head;
    }
}
