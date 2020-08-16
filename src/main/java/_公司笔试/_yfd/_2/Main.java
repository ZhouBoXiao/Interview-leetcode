package _公司笔试._yfd._2;

import java.util.*;

/**
 * @Description:
 * @Author:zhouboxiao@rd.netease.com
 * @Date: 2020/8/1 18:44
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 0) {
            System.out.println(0);
            return;
        }
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int st = scanner.nextInt();
            int ed = scanner.nextInt();
            list.add(new int[]{st, 1});
            list.add(new int[]{ed, -1});
        }
        Collections.sort(list, Comparator.comparingInt(a -> a[0]));
        int cnt = 0, max = 0;
        for (int[] t : list) {
            cnt += t[1];
            max = Math.max(max, cnt);
        }
        System.out.println(max);

        scanner.close();
    }
}
/*
4
1 4
1 2
2 3
3 4

6
1 2
2 3
3 4
5 6
1 6
2 4
 */
