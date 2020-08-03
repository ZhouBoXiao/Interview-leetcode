package 面试相关._滑动窗口算法;

import java.util.Date;

/**
 * @Description:
 * @Author:zhouboxiao@rd.netease.com
 * @Date: 2020/8/2 22:09
 */
public class SlidingWindow {
    private long[][] arr = { { 0 }, { 0 }, { 0 }, { 0 }, { 0 }, { 0 } };

    private final int max = 100;

    private long size = 600000;// 窗口大小

    private long time = new Date().getTime();// 窗口开始时间

    public boolean trafficMonitoring() {

        long nowTime = new Date().getTime();// 请求进来的时间

        // 计算坐标
        long result = (nowTime - time) % 10000;

        int index = 0;

        if (result == 0) {
            index = (int) (nowTime / time);
        } else {

            index = (int) (nowTime / time + 1);
        }
        if (index > arr.length) {
            // 不在窗口内，将滑动窗口平移
            for (int i = 0; i < index - arr.length; i++) {
                // 将数组平移
                for (int j = 0; j < arr.length - 1; j++) {

                    arr[j][0] = arr[j + 1][0];
                }
                // 将起始时间也向前推进一个窗口
                time += 10000;
            }
            // 本次插入的窗口为最后一个窗口
            index = arr.length - 1;
        }
        // 计算窗口总的请求数是否小于阈值
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i][0];
        }
        if (total > max) {
            return false;
        }
        // 获取小窗口目前的请求值
        long count = arr[index - 1][0];
        // 加上本次请求数
        arr[index - 1][0] = count + 1;

        return true;
    }

}
