package _剑指offer._数据流的中位数;

import java.util.PriorityQueue;

/**
 * @Description:
 * @Author:zhouboxiao@rd.netease.com
 * @Date: 2020/7/27 22:27
 */
public class MedianFinder {

    PriorityQueue<Integer> left;//大顶
    PriorityQueue<Integer> right;//小顶
    public MedianFinder() {
        left=new PriorityQueue<>((n1,n2)->n2-n1);
        right=new PriorityQueue<>();
    }
    public void addNum(int num) {
        left.add(num);
        right.add(left.poll());
        if(left.size()+1<right.size())
            left.add(right.poll());
    }
    public double findMedian() {
        if(right.size()>left.size())return right.peek();
        return (double)(left.peek()+right.peek())/2;
    }
}