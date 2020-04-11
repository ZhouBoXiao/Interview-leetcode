package _webank._2;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] a = new int[n][2];
        for (int i = 0 ; i < n; i++) {
            a[i][0] = scanner.nextInt();
            a[i][1] = scanner.nextInt();
        }
        Arrays.sort(a, (v1 , v2) -> {
            if (v2[1] == v1[1])
                return v2[0] - v1[0];
            return v2[1] - v1[1];

        });
        int cnt = 1;
        int res = 0;
        for (int i = 0 ; i < n && cnt > 0; i++, cnt--) {
            res += a[i][0];
            cnt += a[i][1];
        }

        System.out.println(res);
        scanner.close();
    }
}
