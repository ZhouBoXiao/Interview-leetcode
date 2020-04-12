package 面试相关.求出现次数的TopK;

import java.util.*;

public class Solution {
    public static class Node {
        public String str;
        public int times;

        public Node(String s, int t) {
            str = s;
            times = t;
        }
    }

    public static void printTopKAndRank(String[] arr, int topK) {
        if (arr == null || topK < 1) {
            return;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i != arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        Queue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.times));
        int index = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String str = entry.getKey();
            int times = entry.getValue();
            Node node = new Node(str, times);
            if (index != topK) {
                pq.offer(node);
                index++;
            } else {
                // peek element has min occurences in topK element
                if (pq.peek().times < node.times) {
                    pq.poll();
                    pq.offer(node);
                }
            }
            int len = pq.size();
            List<Node> rst = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                // Once poll an element the heap will heapify again.
                rst.add(pq.poll());
            }

        }
    }
    public static String[] generateRandomArray(int len, int max) {
        String[] res = new String[len];
        for (int i = 0; i != len; i++) {
            res[i] = String.valueOf((int) (Math.random() * (max + 1)));
        }
        return res;
    }

    public static void printArray(String[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        String[] arr = generateRandomArray(50, 10);
        int topK = 5;
        printArray(arr);
        printTopKAndRank(arr, topK);

    }
}
