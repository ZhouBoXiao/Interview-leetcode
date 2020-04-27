package _公司笔试._腾讯笔试._1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (n-- > 0 ) {
            String str = scanner.next();

            if ("add".equals(str)) {
                int t = scanner.nextInt();
                s1.push(t);
            } else if("peek".equals(str)) {
                if (s2.isEmpty()) {
                    while (!s1.isEmpty()) {
                        s2.push(s1.pop());
                    }

                }
                System.out.println(s2.peek());
            } else if ("poll".equals(str)) {
                if (s2.isEmpty()) {
                    while (!s1.isEmpty()) {
                        s2.push(s1.pop());
                    }
                }
                s2.pop();
            }
        }
        scanner.close();
    }
}
