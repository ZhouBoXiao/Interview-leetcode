package _公司笔试._tx._1;

/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/9/6 20:01
 */

import java.util.*;

public class Main {

    void solve() {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextInt();
        long m = sc.nextInt();
        long[] p = new long[(int) (n + 1)];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        for (int i = 0; i < m; i++) {

            int x = sc.nextInt();
            long[] temp = new long[x];
            for (int j = 0; j < x; j++) {
                temp[j] = sc.nextLong();
            }
            for (int j = 0; j < x; j++) {
                if (j >= 1) {
                    union(p, temp[j - 1], temp[j]);
                }
            }
        }
        int res = 1;
        for (int i = 1; i < n; i++) {
            if (isSame(p, 0, i)) {
                res++;
            }
        }
        System.out.println(res);
    }

    private void union(long[] p, long x, long y) {
        long px = find(p, x);
        long py = find(p, y);
        if(px != py) {
            p[(int) px] = py;
        }
    }

    long find(long[] p, long x) {
        if (p[(int) x] == x) return x;
        else return p[(int) x] = find(p, p[(int) x]);
    }

    boolean isSame(long[] p, long x, long y) {
        return find(p, x) == find(p, y);
    }
    public static void main(String[] args) {
        new Main().solve();
    }
}
/*

50 5
2 1 2
5 10 11 12 13 14
2 0 1
2 49 2
4 6 7 2 10


10 2
1 1
1 2
 */