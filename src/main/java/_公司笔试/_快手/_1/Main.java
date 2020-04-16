package _公司笔试._快手._1;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        Stack<Character> stack = new Stack<>();
        int a = 0, b = 0, c = 0;
        for (int i = 0 ; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if(s.charAt(i) == ')'){
                if (!stack.isEmpty()) {
                    stack.pop();
                    a++;
                } else {
                    c++;
                }
            }

        }

        b= stack.size();
        System.out.println(a + " " + b + " " + c);

        scanner.close();

    }
}
