package _0_100._17;

import _alibaba._2.Main;

import java.util.*;

public class Solution {

    Map<Character, String> map = new HashMap<>();


    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits  == null || digits.length() == 0) return list;
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        char[] ch = digits.toCharArray();
        dfs(0, ch, list, new StringBuilder());

        return list;
    }

    void dfs(int index, char[] chars, List<String> res, StringBuilder str) {
        if (index == chars.length) {
            res.add(str.toString());
            return;
        }

        char[] tmp = map.get(chars[index]).toCharArray();
        for (char c : tmp) {
            str.append(c);
            dfs(index + 1, chars, res, str);
            str.deleteCharAt(str.length() - 1);
        }

    }

    public static void main(String[] args) {
        new Solution().letterCombinations("23456789");
    }
}
