package _公司笔试._xc;


/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/9/8 19:19
 */


import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String[] strs = s1.split(" ");
        int n = strs.length;

        List<String> res  = new ArrayList<>();

        dfs(res, new StringBuilder(), strs, n, 0);

        Collections.sort(res, Comparator.naturalOrder());
        for (String s : res) {
            print(s);
        }
    }

    static void print(String s) {
        Set<Character> set = new HashSet<>();
        boolean flag = false;
        for (char ch : s.toCharArray())  {
            if (set.contains(ch)) {
                flag = true;
                break;
            }
            set.add(ch);
        }

        if (flag) {
            System.out.println(s + "--circular dependency");
        } else {
            System.out.println(s);
        }

    }

    static void dfs(List<String> res, StringBuilder sb, String[] strs, int n, int index) {

        if (index == n) {

            res.add(sb.toString());
//            print(temp);
            return;
        }
        for (int i = 0; i < strs[index].length(); i++) {
            sb.append(strs[index].charAt(i));
            dfs(res, sb, strs, n, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
