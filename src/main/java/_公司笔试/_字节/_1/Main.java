package _公司笔试._字节._1;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/11 9:59
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        int a[] = new int[n];
        String b[] = new String[n];
        String d[] = new String[n];
        boolean c[] = new boolean[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            if (a[i]!=4) {
                b[i] = scanner.next();
            }
        }
        for (int i = 0; i < n; i++) {
            if (a[i] == 1) {
                sb.append(b[i]);
            } else if (a[i] == 2) {
                int k = Integer.parseInt(b[i]);
                if (sb.length() > k) {
                    d[i] = sb.substring(sb.length() - k,sb.length() );
                    sb.delete(sb.length() - k, sb.length());
                } else {
                    d[i] = sb.substring(0, sb.length());
                    sb.delete(0,sb.length());
                }
            } else if (a[i] == 3) {
                int k = Integer.parseInt(b[i]);
                if (k>=1)
                    System.out.println(sb.charAt(k-1));
            } else if (a[i] == 4) {
                for (int j = i - 1; j >= 0; j--) {
                    if (!c[j] && (a[j] == 1 || a[j] == 2)) {
                        if (a[j] == 1) {
                            if (sb.length() > 0) {
                                sb.delete(sb.length() - b[j].length(), sb.length());
                            }
                        } else if (a[j] == 2) {
                            if (d[j] != null && d[j].length() > 0)
                                sb.append(d[j]);
                        }

                        c[j] = true;
                        break;
                    }
                }
            }

        }

        scanner.close();
    }
}
