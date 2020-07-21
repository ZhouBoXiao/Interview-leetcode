package _题型分类._贪心._1353_最多可以参加的回忆数目;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @Description:
 * @Author:zhouboxiao@rd.netease.com
 * @Date: 2020/7/21 21:25
 */
public class Solution {
    public int maxEvents(int[][] events) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(events, (a, b) ->{
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        for (int[] event : events) {
            for (int i = event[0]; i <= event[1]; i++){
                if (!set.contains(i)) {
                    set.add(i);
                    break;
                }
            }
        }
        return set.size();
    }

    public int maxEvents1(int[][] events) {
        //首先排序：开始时间小的在前。这样是方便我们顺序遍历，把开始时间一样的都放进堆
        Arrays.sort(events, (o1, o2) -> o1[0] - o2[0]);
        //小顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //结果、开始时间、events下标、有多少组数据
        int res = 0, last = 1, i = 0, n = events.length;
        while (i < n || !pq.isEmpty()) {
            //将start相同的会议都放进堆里
            while (i < n && events[i][0] == last) {
                pq.offer(events[i++][1]);
            }
            //pop掉当前天数之前的
            while (!pq.isEmpty() && pq.peek() < last) {
                pq.poll();
            }
            //顶上的就是俺们要参加的
            if (!pq.isEmpty()) {
                pq.poll();
                res++;
            }
            last++;
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().maxEvents1(new int[][]{{1,4},{4,4},{2,2},{3,4},{1,1}});
    }
}
