package _题型分类._链表._环形链表;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/14 17:53
 */

class Node{
    int val;
    Node next;
    Node(int x) {val = x;}
}

public class Solution {
    private Node first = null;
    public void add(int nums) {
        Node cur = null;
        for (int i = 1; i <= nums ; i++) {
            Node node = new Node(i);
            if (i == 1) {
                first = node;
                first.next = first;
                cur = first;
            } else {
                cur.next = node;
                node.next = first;
                cur = node;
            }

        }
    }
}
