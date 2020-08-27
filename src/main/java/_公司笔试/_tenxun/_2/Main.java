package _公司笔试._tenxun._2;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/8/23 20:31
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int k = scanner.nextInt();
        int size = k;
        TreeSet<String> set = new TreeSet<>();
        for (int i = 0; i < s.length() ; i++) {
            for (int j = 0; j < 5; j++) {
                if (i + j >= s.length()) continue;
                String temp = s.substring(i, j + 1);
                set.add(temp);
            }
        }
        Iterator<String> it = set.iterator();
        while (--k >  0) it.next();
        System.out.println(it.next());
    }

    static int compare(String a, String b) {
        if (a.length() == b.length()) {
            return a.compareTo(b);
        }
        for (int i = 0, j = 0; i < a.length() || j < b.length(); i++, j++) {
            if (i >= a.length()) return -1;
            if (j >= b.length()) return 1;
            if (a.charAt(i) < b.charAt(j)) {
                return -1;
            } else if (a.charAt(i) > b.charAt(j)) {
                return 1;
            }
        }
        return 0;
    }
}
