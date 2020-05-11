package _公司笔试._字节._4;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/11 9:59
 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(scanner.nextLine());
        int n = scanner.nextInt();
        Set<Character> set = new HashSet<>();
        int[] res = new int[sb.length()+1];
        for (int j = 0; j < sb.length(); j++) {
            set.add(sb.charAt(j));
            res[j+1] = set.size();
        }
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();


            if (a == 1) {
                int pos = scanner.nextInt();
                String c = scanner.next();
                sb.setCharAt(pos -1, c.charAt(0));
                Set<Character> set1 = new HashSet<>();
//                int[] res = new int[sb.length()];
                for (int j = 0; j < sb.length(); j++) {
                    set1.add(sb.charAt(j));
                    res[j+1] = set1.size();
                }
            } else if (a == 2) {
                int l = scanner.nextInt();
                int r = scanner.nextInt();
//                Set<Character> set = new HashSet<>();
//
//                for (int j = l - 1; j <= r - 1; j++) {
//                    set.add(sb.charAt(j));
//                }
                System.out.println(res[r] - res[l-1]);

            }

        }
        scanner.close();
    }
}
