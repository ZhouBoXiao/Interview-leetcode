package _sortByNumber._301_400._352_将数据流变为多个不相交区间;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/8/17 20:40
 */
public class SummaryRanges {

    /**
     *     1，2，4，7，9
     *     [1, 2] [4, 7] [9, 9]
     *     R[1] = 2, R[4] = 7, R[9] = 9
     *     L[2] = 1, L[7] = 4; L[9] = 9;
      */


    TreeMap<Integer, Integer> L, R;
    /** Initialize your data structure here. */
    public SummaryRanges() {
        L = new TreeMap<>();
        R = new TreeMap<>();
    }

    public void addNum(int x) {
        if (!R.isEmpty()) {
            // 判断x 是否已经被插入
            Map.Entry<Integer, Integer> entry = R.floorEntry(x);
             //                        entry的右端点 >= x
            if (entry != null && entry.getValue() >= x) return;
        }
        // 判断 x-1 左边界是否存在，存在则合并 [ L.get(x-1) , x-1] [x , x]， x+ 1的右边界存在 则合并 [x, x] [x + 1, R.get(x+1)]
        boolean left = L.containsKey(x - 1) , right = R.containsKey(x + 1);

        if (left && right) {
            R.put(L.get(x-1), R.get(x+1));
            L.put(R.get(x+1), L.get(x- 1));
            L.remove(x - 1);
            R.remove(x + 1);
        } else if (left) {
            R.put(L.get(x-1), x);
            L.put(x, L.get(x-1));
            L.remove(x - 1);
        } else if (right) {
            L.put(R.get(x+1), x);
            R.put(x, R.get(x+1));
            R.remove(x + 1);
        } else {
            L.put(x, x);
            R.put(x, x);
        }
    }

    public int[][] getIntervals() {
        List<int[]> res = new ArrayList<>();
        R.forEach((o1, o2) -> {
            int[] temp = new int[2];
            temp[0] = o1;
            temp[1] = o2;
            res.add(temp);
        });
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        SummaryRanges summaryRanges = new SummaryRanges();
        summaryRanges.addNum(6);
        summaryRanges.getIntervals();
        summaryRanges.addNum(6);
        summaryRanges.getIntervals();
        summaryRanges.addNum(0);
        summaryRanges.getIntervals();
        summaryRanges.addNum(4);
        summaryRanges.getIntervals();
        summaryRanges.addNum(8);
        summaryRanges.addNum(7);
        summaryRanges.addNum(6);
        summaryRanges.addNum(4);
        summaryRanges.addNum(7);
        summaryRanges.addNum(5);
        summaryRanges.getIntervals();

    }
}
