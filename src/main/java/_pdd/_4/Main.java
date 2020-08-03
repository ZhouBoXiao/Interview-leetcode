package _pdd._4;

/**
 * @Description:
 * @Author:zhouboxiao@rd.netease.com
 * @Date: 2020/8/2 18:47
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k  = scanner.nextInt();
        int n = scanner.nextInt();
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = scanner.nextInt();
        }
        if (k == 0) {
            System.out.println("paradox");
            return;
        }
        int sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            sum += d[i];
            if (sum == k) {
                System.out.println("paradox");
                return;
            } else if (sum > k) {
                sum = k - sum % k;
                count++;
            }
        }
        System.out.println(k - sum + " " + count);
        scanner.close();
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