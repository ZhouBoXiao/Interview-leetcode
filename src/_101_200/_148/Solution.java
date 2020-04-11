package _101_200._148;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

/**
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 */
public class Solution {
    public ListNode sortList(ListNode head) {

        return head == null ? null : mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if (head.next == null) return head;
        ListNode p = head, q = head, pre= null;
        while (q != null && q.next != null) {
            pre = p;
            p = p.next;
            q = q.next.next;
        }
        pre.next = null;
        ListNode l = mergeSort(head);
        ListNode r = mergeSort(p);

        return merge(l, r);
    }

    private ListNode merge(ListNode l, ListNode r) {
        ListNode temp = new ListNode(0);
        ListNode cur = temp;
        while (l != null && r != null) {
            if(l.val <= r.val) {
                cur.next = l;
                cur = cur.next;
                l = l.next;
            } else{
                cur.next = r;
                cur = cur.next;
                r = r.next;
            }
        }
        if (l != null) {
            cur.next = l;
        }
        if (r != null) {
            cur.next = r;
        }
        return temp.next;

    }


}
