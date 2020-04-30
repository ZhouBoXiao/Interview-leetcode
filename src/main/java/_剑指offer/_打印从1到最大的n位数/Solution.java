package _剑指offer._打印从1到最大的n位数;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/4/30 15:13
 */
public class Solution {
    public void printNumbers(int n) {
        StringBuilder str = new StringBuilder();
        // 将str初始化为n个'0'字符组成的字符串
        for (int i = 0; i < n; i++) {
            str.append('0');
        }
        while (!increment(str)) {
            int index = 0;
            while (index < str.length() && str.charAt(index) == '0') {
                index++;
            }
            System.out.println(str.toString().substring(index));
        }
    }

    private boolean increment(StringBuilder str) {
        boolean isOverflow = false;
        for (int i = str.length() - 1; i >= 0; i--) {
            char s = (char) (str.charAt(i) + 1);
            if (s > '9') {
                str.replace(i, i+1, "0");
                if (i == 0) {
                    isOverflow = true;
                }
            } else {
                str.replace(i, i +1, String.valueOf(s));
                break;
            }
        }
        return isOverflow;
    }

}
