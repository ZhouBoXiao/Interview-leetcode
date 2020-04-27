package _公司笔试._腾讯笔试._2;


import java.util.*;

class ListNode{
    int val;
    ListNode next;
    ListNode pre;
    ListNode(int x) {val = x;}
}

public class Main {
    static ListNode head;
    static ListNode tail;
    static int size = 0 ;

    public static int size() {
        return size;
    }
    public static void clear() {
        head = null;
        tail = null;
        size = 0;
    }
    public static void add(ListNode newNode) {
        if (newNode == null) {
            return;
        }
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.pre = tail;
            tail = newNode;
        }
        size++;
    }

    public static void poll() {
        if (head == null) {
            return;
        }
        ListNode res = head;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = res.next;
            head.pre = null;
            res.next = null;
        }
        size--;
    }
    private static boolean isEmpty() {
        return head == null ? true : false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t =  scanner.nextInt();


        List<Integer> res = new ArrayList<>();
        while (t-- > 0) {
            int q = scanner.nextInt();
            clear();
            while (q-- > 0) {
                String s = scanner.next();

                if (!"PUSH".equals(s)) {
                    if (s.charAt(0) == 'P') {
                        if (isEmpty()) res.add(-1);
                        else poll();
                    } else if (s.charAt(0) == 'T') {
                        if (isEmpty()) res.add(-1);
                        else res.add(head.val);

                    } else if (s.charAt(0) == 'S') {
                        res.add(size());
                    } else if (s.charAt(0) == 'C') {
                        clear();
                    }
                } else {
                    int tmp = scanner.nextInt();
                    add(new ListNode(tmp));
                }

            }

        }
        for (int t1 : res) {
            System.out.println(t1);
        }
        scanner.close();

    }




}
/*
2
7
PUSH 1
PUSH 2
CLEAR
TOP
TOP
TOP
TOP
1
POP
 */