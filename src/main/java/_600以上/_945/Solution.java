package _600以上._945;

import java.util.Arrays;

/*
给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。

返回使 A 中的每个值都是唯一的最少操作次数。

示例 1:

输入：[1,2,2]
输出：1
解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
示例 2:

输入：[3,2,1,2,1,7]
输出：6
解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
提示：

0 <= A.length <= 40000
0 <= A[i] < 40000

 */
public class Solution {

    int[] pos = new int [80000];
    public int minIncrementForUnique(int[] A) {
        Arrays.fill(pos, -1); // -1表示空位
        int move = 0;
        // 遍历每个数字a对其寻地址得到位置b, b比a的增量就是操作数。
        for (int a: A) {
            int b = findPos(a);
            move += b - a;
        }
        return move;
    }

    // 线性探测寻址（含路径压缩）
    private int findPos(int a) {
        int b = pos[a];
        // 如果a对应的位置pos[a]是空位，直接放入即可。
        if (b == -1) {
            pos[a] = a;
            return a;
        }
        // 否则向后寻址
        // 因为pos[a]中标记了上次寻址得到的空位，因此从pos[a]+1开始寻址就行了（不需要从a+1开始）。
        b = findPos(b + 1);
        pos[a] = b; // 寻址后的新空位要重新赋值给pos[a]哦，路径压缩就是体现在这里。
        return b;
    }
    public static void main(String[] args) {
        int[] a = new int[]{3,2,1,2,1,7};
        System.out.println(new Solution().minIncrementForUnique(a));
    }
}
/*
public int minIncrementForUnique(int[] A) {

        int[] counter = new int[40001];
        int max = 0;
        for (int i = 0; i < A.length ; i++) {
            counter[A[i]]++;
            max = Math.max(max, A[i]);
        }
        int move = 0;
        for (int i = 0; i <= max ; i++) {

            if (counter[i] > 1) {
                int d = counter[i] - 1;
                counter[i+1] += d;
                move += d;
            }
        }

        int d = counter[max + 1] - 1;
        move += d * (d + 1) /2;
        return move;

    }
 */