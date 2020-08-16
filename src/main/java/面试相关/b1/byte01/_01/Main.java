package 面试相关.b1.byte01._01;

import java.util.Scanner;

/**
 * 1. 三个同样的字母连在一起，一定是拼写错误，去掉一个的就好啦：比如 helllo -> hello
 * 2. 两对一样的字母（AABB型）连在一起，一定是拼写错误，去掉第二对的一个字母就好啦：比如 helloo -> hello
 * 3. 上面的规则优先“从左到右”匹配，即如果是AABBCC，虽然AABB和BBCC都是错误拼写，应该优先考虑修复AABB，结果为AABCC
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-- > 0) {
            String s = scanner.next();
            //char[] chars = s.toCharArray();
            for (int i = 0; i < s.length();) {

                if (i >= 2) {
                    if (s.charAt(i-1) == s.charAt(i-2)  && s.charAt(i-1) == s.charAt(i)) {
                        s= s.substring(0, i)+s.substring(i+1);
                        continue;
                    }
                }
                if (i >= 3) {
                    if (s.charAt(i-1) == s.charAt(i)  && s.charAt(i-2) == s.charAt(i-3)) {
                        s= s.substring(0, i)+s.substring(i+1);
                        continue;
                    }
                }
                i++;
            }
            System.out.println(s);
        }

        scanner.close();
    }
}
