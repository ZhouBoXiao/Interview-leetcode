package _公司笔试._pdd._1;

/**
 * @Description:
 * @Author:zhouboxiao@rd.netease.com
 * @Date: 2020/8/2 18:47
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] a = new int[n][6];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 6; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        int count = 1 ;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                int same = same(a[i], a[j]);
                if (same == -1) {
                    count++;
                } else {
                    map.put(same, map.getOrDefault(same, 0) + 1);
                }

            }
        }
        List<Integer> list = new ArrayList<>();
        map.forEach((k,v) ->{
            list.add(v);
        });
        Collections.sort(list, (a1, b1) -> b1 - a1);
//        list.add();
        int sum = 0;
        for (int s : list) {
            sum += s;
        }
        while (sum < n) {
            list.add(1);
            sum++;
        }
        System.out.println(count);
        for (int i = 0; i< list.size() ;i ++) {
            if (i == list.size() - 1) System.out.println(list.get(i));
            else System.out.print(list.get(i) + " ");
        }
//        System.out.println();
    }
    // right -》 left
    void left(int[] a) {
        int temp1 = a[2];
        int temp2 = a[3];
        a[2] = a[4];
        a[3] = a[5];
        a[4] = temp2;
        a[5] = temp1;
    }
    void right(int[] a) {
        int temp1 = a[2];
        int temp2 = a[3];
        a[2] = a[5];
        a[3] = a[4];
        a[4] = temp1;
        a[5] = temp2;
    }
    //
    void down(int[] a) {
        int temp1 = a[0];
        int temp2 = a[1];
        a[0] = a[5];
        a[1] = a[4];
        a[4] = temp1;
        a[5] = temp2;
    }


    void swap(int[] a, int i, int j) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }

    static int same(int[] a, int[] b) {
        Set<int[]> set1 = new TreeSet<>(Comparator.comparingInt(o -> o[0]));
        Set<int[]> set2 = new TreeSet<>(Comparator.comparingInt(o -> o[0]));
        //Set<Integer> set3 = new HashSet<>(2);
        int min = Math.min(a[0], a[1]);
        int max = Math.max(a[0], a[1]);
        set1.add(new int[]{min, max});
        min = Math.min(a[2], a[3]);
        max = Math.max(a[2], a[3]);
        set1.add(new int[]{min, max});
        min = Math.min(a[4], a[5]);
        max = Math.max(a[4], a[5]);
        set1.add(new int[]{min, max});

        min = Math.min(b[0], b[1]);
        max = Math.max(b[0], b[1]);
        set2.add(new int[]{min, max});
        min = Math.min(b[2], b[3]);
        max = Math.max(b[2], b[3]);
        set2.add(new int[]{min, max});
        min = Math.min(b[4], b[5]);
        max = Math.max(b[4], b[5]);
        set2.add(new int[]{min, max});

        if (set1.containsAll(set2)) {
            int sum = 0;
            for (int[] o : set1) {
                sum = sum * 10 + (o[0] * 10 + o[1]);
            }
            return sum;
        }
        return -1;
    }


}
/*
10 4
6 3 3 3


10 2
6 3
 */

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int k  = scanner.nextInt();
//        int n = scanner.nextInt();
//        int[] d = new int[n];
//        for (int i = 0; i < n; i++) {
//            d[i] = scanner.nextInt();
//        }
//        int sum = 0;
//        int count = 0;
//        for (int i = 0; i < n; i++) {
//            sum += d[i];
//            if (sum == k) {
//                System.out.println("paradox");
//                return;
//            } else if (sum > k) {
//                sum = k - sum % k;
//                count++;
//            }
//        }
//        System.out.println(k - sum + " " + count);
//        scanner.close();
//    }