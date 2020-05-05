package _公司笔试.leetcode._第187场周赛._5403;

import java.util.*;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/3 10:49
 */
public class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int sum = 0;
        for (int i = 0 ; i < mat.length; i++) {
            sum += mat[i][0];
        }
        PriorityQueue<Item> pq = new PriorityQueue<>((Comparator.comparingInt(o -> o.total)));
        Set<String> visit = new HashSet<>();
        Item first = new Item(new int[mat.length], sum);
        visit.add(Arrays.toString(first.pick));
        pq.offer(first);
        while (k > 1) {
            Item item = pq.poll();
            for (int i = 0; i < mat.length ; i++) {
                item.pick[i]++;

                if (item.pick[i] < mat[i].length && !visit.contains(Arrays.toString(item.pick))) {
                    visit.add(Arrays.toString(item.pick));
                    int[] pick = Arrays.copyOf(item.pick, item.pick.length);
                    int total = item.total - mat[i][item.pick[i] - 1] + mat[i][item.pick[i]];
                    pq.add(new Item(pick, total));
                }
                item.pick[i]--;
            }
            k--;
        }
        return pq.peek().total;

    }

    public static void main(String[] args) {
        int[][] nums= new int[][]{{1,10,10},{1,4,5},{2,3,6}};
        new Solution().kthSmallest(nums, 7);
    }
    private class Item{
        private int[] pick;
        private int total;
        public Item(int[] pick, int total) {
            this.pick = pick;
            this.total = total;
        }
    }
}
