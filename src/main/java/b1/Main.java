package b1;

import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        System.out.println(new Main().solution(s));
    }
    String solution(String s) {
        char[] chars = s.toCharArray();

        Stack<Integer> stack = new Stack<>();

        for (int i = 0 ; i < chars.length ; i++){


            if (chars[i] == '['){
                stack.add(i);
            }else if (chars[i] == ']'){

                int pre = stack.pop();

                int a = s.indexOf("|", pre);
                int times = Integer.parseInt(s.substring(pre+1, a));
                String res = "";
                String S = s.substring(a+1, i);
                for (int j = 0; j < times; j++) {
                    res += S;
                }
                String replaceString = s.substring(pre, i+1);

                return solution(s.replace(replaceString, res));
            }

        }
        return s;
    }


}