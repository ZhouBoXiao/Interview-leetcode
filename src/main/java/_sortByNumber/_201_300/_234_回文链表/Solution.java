package _sortByNumber._201_300._234_回文链表;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/7/7 22:06
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode fast = head, slow = head;
        while (fast != null ) {
            slow = slow.next;
            fast = fast.next != null ? fast.next.next : null;
        }
        ListNode pre = null;
        while (slow != null) {
            ListNode node = slow.next;
            slow.next = pre;
            pre = slow;
            slow = node;
        }
        while (head != null && pre != null) {
            if (head.val != pre.val) {
                return false;
            }
            head = head.next;
            pre = pre.next;
        }
        return true;
    }
}
