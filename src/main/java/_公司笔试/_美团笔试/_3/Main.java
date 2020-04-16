package _公司笔试._美团笔试._3;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
//        int n = 100;

        int k = scanner.nextInt();
//        int k = 100;
        long m = scanner.nextLong();
//        long m = 2000000000;
        int p = scanner.nextInt();
        int q = scanner.nextInt();
//        int p =100, q=100;
        int[] t = new int[k];
        for (int i = 0; i < k; i++) {
            t[i] = scanner.nextInt();
//            t[i] = 1000000;
        }
        Arrays.sort(t);
        long res = 0;
        while (m > 0 && n >0) {
            boolean flag = false;
            for (int i = 0; i < k; i++) {
                if (m >= t[i]) {
                    m -= t[i];
                    res +=p;
                } else {
                    flag = true;
                }
            }
            if (!flag) {
                res += q;
            }
            n--;
        }
        System.out.println(res);
    }

}
