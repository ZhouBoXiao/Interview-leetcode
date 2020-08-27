package _公司笔试.jd;

/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/8/27 19:24
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        PriorityQueue<String> q = new PriorityQueue<>((a,b)->{
            int len1 = a.length();
            int len2 = b.length();
            int lim = Math.min(len1, len2);
            if (len1 == len2) {
                int k = 0;
                while (k < lim) {
                    char c1 = a.charAt(k);
                    char c2 = b.charAt(k);
                    if (c1 != c2) {
                        return c1 - c2;
                    }
                    k++;
                }

            }
            return len1 - len2;
        });

        for (int i = 1; i <= n; i++) {
            String s = q.size() > 0 ? q.poll() : "";
            q.add(s + "2");
            q.add(s + "3");
            q.add(s + "5");
        }
        System.out.println(q.poll());
        scanner.close();
    }
}
