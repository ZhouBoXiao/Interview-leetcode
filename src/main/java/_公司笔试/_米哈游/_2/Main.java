package _公司笔试._米哈游._2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
//        s = s.toLowerCase();
        char[] chars = s.toCharArray();
        int[] map = new int[128];
        int pre  = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                String tmp = s.substring(pre, i);
                int times = chars[i] - '0';
                if (tmp.indexOf("-") != -1) {
                    char[] temp = extend(chars, pre, i - 1);
                    for (char ch : temp) {
                        if (ch < 'a') map[ch+32] += times;
                        else map[ch] += times;
                    }
                } else {
                    for (int j = pre; j < i; j ++) {
                        if (chars[j] < 'a') map[chars[j]+32] += times;
                        else map[chars[j]] += times;
                    }
                }


                pre = i + 1;
            }
        }
        int max = 0;
        char res = ' ';
        char base = ' ' - 32;
        for (int i = 0 ;i < 128; i++) {
            if (map[i] > max) {
                max = map[i];
                res = (char) (base + (char) i);
            }

        }
        System.out.println(""+res + max);
        scanner.close();
    }

    private static char[] extend(char[] chars, int start, int end) {
        char[] res = null;
        char chStart = chars[start];
        char chEnd = chars[end];
        List<Character> list = new ArrayList<>();
        if (chEnd == chStart) res = new char[]{chEnd};
        if (chStart >= 'a' && chEnd <= 'z') {
            for (char ch = chStart; ch <= chEnd; ch++) {
                list.add(ch);
            }
        }
        else if (chStart >= 'A' && chEnd <= 'Z') {
            for (char ch = chStart; ch <= chEnd; ch++) {
                list.add(ch);
            }
        }
        else if (chStart < 'a' && chEnd >= 'a') {

            for (char ch = chStart; ch <= 'Z'; ch++) {
                list.add(ch);
            }
            for (char ch = 'a'; ch <= chEnd; ch++) {
                list.add(ch);
            }
        } else if (chEnd < 'a'){
            for (char ch = chEnd; ch <= 'Z'; ch++) {
                list.add(ch);
            }
            for (char ch = 'a'; ch <= chStart; ch++) {
                list.add(ch);
            }
        }
        res = new char[list.size()];
        int index = 0;
        for (char ch : list) {
            res[index++] = ch;
        }
        return res;
    }
}
/*
A3bc2X-b2
private static char[] extend(char[] chars, int start, int end) {
        char[] res = null;

        char chStart = chars[start];
        char chEnd = chars[end];
        if (chEnd == chStart) res = new char[]{chEnd};
        if (chStart < chEnd) {
            res = new char[chEnd - chStart + 1];
            int index = 0;
            for (char ch = chStart; ch <= chEnd; ch++) {
                res[index++] = ch;
            }
        } else if (chStart >  chEnd){
            int len = 'z' - chStart + chEnd - 'a' + 2;
            res = new char[len];
            int index = 0;
            for (char ch = chStart; ch <= 'z'; ch++) {
                res[index++] = ch;
            }
            for (char ch = 'a'; ch <= chEnd; ch++) {
                res[index++] = ch;
            }
        }
        return res;
    }
 */