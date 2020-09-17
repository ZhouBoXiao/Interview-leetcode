package _sortByNumber._0_100._19_删除链表的倒数第N个节点;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/5 15:00
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null ) return null;
        ListNode p1 = head;
        ListNode p2 = head;
        for (int i = 0; i < n ; i++) {
            if (p2!=null)
                p2 = p2.next;
            else break;
        }
        if (p2 == null) {
            return head.next;
        }
        while (p2.next != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        p2 = p1.next;
        p1.next = p2.next;
        return head;

    }

    int cur = 0;
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if (head == null) return null;
        head.next = removeNthFromEnd1(head.next, n);
        cur++;
        if (n == cur) return head.next;
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        ListNode pre  = head;
        for (int i = 2; i <= 5; i++) {
            head.next = new ListNode(i );
            head = head.next;
        }
        solution.removeNthFromEnd1(pre, 2);
    }


}
