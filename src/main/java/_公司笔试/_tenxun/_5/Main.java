package _公司笔试._tenxun._5;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int q = scanner.nextInt();
        for (int k = 0; k < q; k++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int res = 0;
            for (int i = l - 1; i < r; i++) {
//                int a = get(i, i , s, l, r);
//                int b = get(i , i + 1 , s, l ,r);
                for (int j =  i + 1; j < r; j++) {

                }
            }
        }
    }

    static int get(int i, int j, String s, int l, int r) {
        while (i >= l && j < r && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }
        return j - i - 1;
    }

}
