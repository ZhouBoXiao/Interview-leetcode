package _贪心._406_根据身高重建队列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/1 11:14
 */
public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length  == 0 || people[0].length == 0) return new int[0][];
        Arrays.sort(people, (a,b)->(a[0]==b[0] ? a[1] - b[1] : b[0] - a[0]));
        List<int[]> queue = new ArrayList<>();
        for (int[] p : people) {
            queue.add(p[1], p);
        }
        return queue.toArray(new int[queue.size()][]);
    }
}
