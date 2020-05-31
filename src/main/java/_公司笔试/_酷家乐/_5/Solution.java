package _公司笔试._酷家乐._5;

import java.util.*;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/26 17:38
 */
public class Solution {
    class Node {
        int i,j,value;
    }
    boolean greater(PriorityQueue<Node> nodes, int a, int b){
        for (Node node : nodes) {
            if (node.i <= a && node.j <= b) {
                return true;
            }
        }
        return false;

    }
    public int[] solve(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[] res = new int[k];
        int count  = 0, i , j;
        Node tmp = new Node();
        tmp.value = nums1[0] + nums2[0];
        tmp.i = 0;
        tmp.j = 0;
//        List<Node> list = new LinkedList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.value));
        pq.add(tmp);
        while (count < k) {
            tmp = pq.peek();
            pq.poll();
            res[count++] = tmp.value;
            i = tmp.i;
            j = tmp.j;

            Node a = new Node(), b = new Node();
            if ((i+1) < n && !greater(pq, i+1, j)){
                a.i = i + 1;
                a.j = j;
                a.value = nums1[i+1] + nums2[j];
                pq.add(a);
            }
            if ((j+1) < n && !greater(pq, i, j+1)){
                b.i = i;
                b.j = j + 1;
                b.value = nums1[i] + nums2[j+1];
                pq.add(b);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 8, 9, 15};
        int[] nums2 = new int[]{1, 9, 11, 12};

        new Solution().solve(nums1, nums2, 16);
    }


}
