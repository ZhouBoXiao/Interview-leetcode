package _公司笔试._米哈游._1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i ++) {
            nums[i][0] = scanner.nextInt();
            nums[i][1] = scanner.nextInt();
        }
        if (n == 0) {
            System.out.println(0);
            return;
        }
        Arrays.sort(nums,(a,b)->{
            if (a[1] == b[1]) {
                return a[0]-b[0];
            } else {
                return a[1]-b[1];
            }
        });
        int max = 0;
        for (int i = 0 ; i < n; i ++) {
            int len = 0;
            for (int j = i +1 ; j < n; j++ ) {
                if(nums[j][0] < nums[i][1] || nums[j][0] == nums[i][0]) {
                    len++;
                }
            }
            max = Math.max(max, len);
        }
        System.out.println(max+1);
        scanner.close();
    }
}
/*
10
1 2
4 5
3 4
7 8
2 7
3 9
9 10
3 4
1 9
1 2

 */