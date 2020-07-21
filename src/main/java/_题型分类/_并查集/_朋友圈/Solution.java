package _题型分类._并查集._朋友圈;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/6/2 14:12
 */
class Solution1 {
    public int findCircleNum(int[][] M) {
        UF uf = new UF(M.length);

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (i != j) {
                    if (M[i][j] == 1) {
                        uf.union(i,j);
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < uf.par.length; i++) {
            if (uf.par[i] == i)
                count++;
        }
        return count;
    }
//    //[[1,0,0,1],[0,1,1,0],[0,1,1,1],[1,0,1,1]]
//    public static void main(String[] args) {
//        int[][] M = new int[][]{
//                {1,0,0,1},
//                {0,1,1,0},
//                {0,1,1,1},
//                {1,0,1,1}
//        };
//        System.out.println(new Solution().findCircleNum(M));
//    }
}


class UF {
    int[] par;
    UF(int n ){
        par = new int[n];
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
    }

    int find(int x) {
        if (par[x] == x) {
            return x;
        } else {
            return par[x] = find(par[x]);
        }
    }

    void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            par[x] = y;
        }
    }

    boolean same(int x, int y) {
        return find(x) == find(y);
    }

}


/*class UF{

    int[] par;

    UF(int n) {
        par = new int[n];
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
    }

    int find(int x) {
        if(par[x] == x) {
            return x;
        } else {
            return par[x] = find(par[x]);
        }
    }

    void union(int x, int y) {
        int u1 = find(x);
        int u2 = find(y);
        if (u1 != u2) {
            par[u1] = u2;
        }
    }

    boolean same(int x, int y) {
        return find(x) == find(y);
    }
}*/

//public class Solution {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int a = in.nextInt();
//        System.out.println(solve(a));
//        System.out.println("Hello World!");
//    }
//    static String solve(int n) {
//        if (n == 0) {
//            return "0";
//        }
//        String s = new String("1");
//        for (int i = 2; i <= n ; i++) {
//            s = getResult(s, String.valueOf(i));
//        }
//        return s;
//    }
//    static String getResult(String nums1, String nums2){
//        int[] res = new int[nums1.length() + nums2.length()];
//        for (int i = nums1.length() - 1; i >= 0;i --) {
//            int num1 = nums1.charAt(i) - '0';
//            for (int j = nums2.length() - 1; j >=0 ; j--) {
//                int num2 = nums2.charAt(j) - '0';
//                int sum = res[i+j+1] + num1 * num2;
//                res[i+j] += sum/10;
//                res[i+j+1] = sum%10;
//            }
//        }
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0 ; i < res.length; i++) {
//            if ( i == 0 && res[i] == 0) {
//                continue;
//            }
//            sb.append(res[i]);
//        }
//        return sb.toString();
//    }
//}
//
//


