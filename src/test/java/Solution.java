import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/27 14:54
 */

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val=x;}
}
public class Solution {

    ListNode solve(List<ListNode> lists) {
        ListNode pre  = new ListNode(-1);
        ListNode head  =  pre;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a->a.val));

        for (int i = 0; i < lists.size(); i++) {
            ListNode node = lists.get(i);
//            lists.set(i,node.next);
            pq.add(node);
        }
        while (!pq.isEmpty()){
            ListNode node = pq.peek();
            pq.poll();
            pre.next = node;
            pre = pre.next;
            for (int i = 0; i < lists.size(); i++) {
                ListNode tmp = lists.get(i);
                if (tmp != null) {
                    if (node.val == tmp.val) {
                        lists.set(i, tmp.next);
                        pq.add(tmp.next);
                        break;
                    }
                }
            }

        }
        return head.next;
    }


    ListNode solve(ListNode head1, ListNode head2) {

        if (head1 == null || head2 == null) {
            return null;
        }
        boolean flag1 = true;
        boolean flag2 = true;
        ListNode p1 = head1, p2 = head2;
        while (p1.val != p2.val) {
            p1 = p1.next;
            p2 = p2.next;
            if (p1 == null && flag1 ) {
                p1 = head2;
                flag1 = false;
            }
            if (p2 == null && flag2) {
                p2 = head1;
                flag2 = false;
            }
        }
        return p1;
    }

    public static void main(String[] args) {
        StringBuilder sb;
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode p1 = new ListNode(3);
        ListNode p2 = new ListNode(4);
        ListNode p3 = new ListNode(5);
        ListNode p4 = new ListNode(6);
        head1.next = p1;
        head2.next = new ListNode(5);
        List<ListNode> list = new ArrayList<>();
        list.add(head1);
        list.add(head2);
        new Solution().solve(list);
    }
}
