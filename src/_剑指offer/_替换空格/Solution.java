package _剑指offer._替换空格;

public class Solution {
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) return s;
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ')
                cnt++;
        }
        int len = s.length() + cnt*2 - 1;
        char[] chars = new char[len + 1];

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                chars[len--] = '0';
                chars[len--] = '2';
                chars[len--] = '%';
            } else {
                chars[len--] = s.charAt(i);
            }
        }
        return new String(chars);
    }
}
