package _公司笔试._趋势科技._2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/7 19:25
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        List<String> res = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int mid1 = i + 1;
            int len1 = valid(s, i, i);
            int len2 = Math.max(valid(s, i, mid1) , len1);
            if (len2 > end - start) {
                start = i - (len2-1)/2;
                end = i + len2/2;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            int mid1 = i + 1;
            int len1 = valid(s, i, i);
            int len2 = Math.max(valid(s, i, mid1) , len1);
            if (len2 == end - start + 1 && len2 > 1) {
                res.add(s.substring(i - (len2-1)/2, i + len2/2 + 1));
            }
        }
        if (res.size() == 0) System.out.println("null");
        else res.forEach(System.out::println);
        scanner.close();

    }

    static  int valid(String s1, int i, int j) {
//        int i = 0, j = s1.length() - 1;
        while (i >=0 && j < s1.length() && s1.charAt(i) == s1.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }
}
