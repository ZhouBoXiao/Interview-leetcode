package _sortByNumber._201_300._295_数据流的中位数;

import java.util.PriorityQueue;

/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/8/17 20:22
 */
public class Solution {

}
class MedianFinder {

    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    /** initialize your data structure here. */
    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>((a, b) -> b- a);
    }

    public void addNum(int num) {
        max.add(num);
        min.add(max.remove());
        if (min.size() > max.size()) {
            max.add(min.remove());
        }
    }

    public double findMedian() {
        if (max.size() == min.size()) {
            return (max.peek() + min.peek()) /2.0;
        } else {
            return max.peek();
        }
    }
}