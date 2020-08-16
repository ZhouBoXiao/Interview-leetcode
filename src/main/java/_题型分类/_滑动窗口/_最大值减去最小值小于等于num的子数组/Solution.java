package _题型分类._滑动窗口._最大值减去最小值小于等于num的子数组;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description:
 *  一个数组，找出最大值和最小值之差<=num的子数组的个数
 * @Author: boxiao
 * @Date: 2020/8/13 22:42
 */
public class Solution {

    int getNum(int[] arr, int num){
        if (arr.length == 0) return 0;
        Deque<Integer> qmin = new ArrayDeque<>();
        Deque<Integer> qmax = new ArrayDeque<>();
        int res = 0;
        int i = 0, j = 0;
        int n = arr.length;
        while (i < n) {
            while (j < n) {
                while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]) {
                    qmin.pollLast();
                }
                qmin.addLast(j);
                while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]) {
                    qmax.pollLast();
                }
                qmax.addLast(j);
                if (arr[qmax.peekFirst()] - arr[qmin.peekFirst()] > num) {
                    break;
                }
                j++;
            }
            if (qmax.peekFirst() == i) {
                qmax.pollFirst();
            }
            if (qmin.peekFirst() == i) {
                qmin.pollFirst();
            }
            res += j - i;
            i++;
        }
        return res;
    }
}
