package _0_100._24_两两交换链表中的节点;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/5 15:27
 */
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
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode a = head, b =head;
        for (int i = 0 ; i <2; i++) {
            if (b == null) return head;
            b = b.next;
        }
        ListNode newHead  = reverse(a, b);
        a.next = swapPairs(b);
        return newHead;
    }

    public static void main(String[] args) {
         ListNode h1 = new  ListNode(1);
         ListNode h2 = new  ListNode(2);
         ListNode h3 = new  ListNode(3);
         ListNode h4 = new  ListNode(4);
         ListNode h5 = new  ListNode(5);
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
        new Solution().swapPairs(h1);
    }
}
