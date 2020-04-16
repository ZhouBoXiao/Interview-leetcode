import java.util.Arrays;
import java.util.List;

class ListNode {
    int val;
    ListNode next = null;
    int t = "abc".length();
    char c = 17;
    ListNode(int val) {
        this.val = val;
    }
}

class Solution{

    /*public static ListNode EntryNodeOfLoop(ListNode pHead) {

        if(pHead==null)
            return null;

        ListNode slow = pHead.next;
        if(slow==null)
            return null;

        ListNode fast = slow.next;

        do{
            fast = fast.next.next;
            slow = slow.next;
        }while(fast!=slow);
        if(slow==null)
            return null;
        ListNode p1 = slow.next;
        int cnt=1;
        while(p1!=slow){
            cnt++;
            p1 = p1.next;
        }
        p1 = pHead;
        while(cnt>0){
            cnt --;
            p1 = p1.next;
        }
        ListNode p2 = pHead;
        while(p1!=p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }*/
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length ==0)
            return false;
        return Verify(sequence, 0, sequence.length-1);
    }
    private boolean Verify(int[] sequence, int first, int last){
        if (first >= last )
            return true;
        int rootval = sequence[last];
        int cur =first;
        while (cur < last && sequence[cur] <= rootval)
            cur++;
        for (int i = cur; i < last ; i++){
            if (sequence[i] < rootval)
                return false;
        }
        return Verify(sequence, first, cur-1) && Verify(sequence, cur, last -1);

    }
    /*public static void main(String[] args) {
        ListNode head = new ListNode(0);;
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);
        ListNode p5 = new ListNode(5);
        ListNode p6 = new ListNode(6);
        ListNode p7 = new ListNode(7);
        head.next = p1;
        p1.next = p2; p2.next = p3; p3.next = p4; p4.next = p5; p5.next = p6; p6.next = p7;
        p7.next = p3;

        System.out.println(EntryNodeOfLoop(head));

    }*/
}

public class Main{
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] sequence = {4,8,6,12,16,14,10};
        solution.VerifySquenceOfBST(sequence);
    }
}