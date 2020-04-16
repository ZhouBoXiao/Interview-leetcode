package _剑指offer._第一个只出现一次的字符位置;

import java.util.*;

public class Main {

    public static int FirstNotRepeatingChar2(String str) {
        BitSet bs1 = new BitSet(256); //存放不重复的元素
        BitSet bs2 = new BitSet(256); //存放和bs1重复的元素

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!bs1.get(ch) && !bs2.get(ch)) {
                bs1.set(ch);
            } else if (bs1.get(ch) &&  !bs2.get(ch)) {
                bs2.set(ch);
            }

        }
        for (int i = 0; i < str.length() ; i++) {
            char ch = str.charAt(i);
            if (bs1.get(ch) && !bs2.get(ch)) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(FirstNotRepeatingChar2("abacc"));
    }
}
