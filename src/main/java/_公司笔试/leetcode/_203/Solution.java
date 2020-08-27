package _公司笔试.leetcode._203;

import java.util.*;

/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/8/23 11:11
 */
public class Solution {
    public static List<Integer> mostVisited(int n, int[] rounds) {
        int[][] res = new int[n + 1][2];
        for (int i = 1; i < rounds.length; i++) {
            for (int j = rounds[i-1]; j != rounds[i]; ) {
                res[j][0]++;
                res[j][1] = j;
                j = j + 1 > n ? 1 : j+1;
            }
        }
        res[rounds[rounds.length-1]][0]++;
        res[rounds[rounds.length-1]][1] = rounds[rounds.length-1];
        Arrays.sort(res, (a,b)->{
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] -a[0];
        });
        List<Integer> ans  = new ArrayList<>();
        int pre = res[0][0];
        ans.add(res[0][1]);
        for (int i = 1; i < res.length; i++) {
            if (pre == res[i][0])
                ans.add(res[i][1]);
            else
                break;
        }
        return ans;
    }
    public static int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int res = 0 ;
        int i = 0, j = piles.length - 1;
        while (i < j) {
            res += piles[j - 1];
            i++;
            j-=2;
        }
        return res;
    }

    int[] par = new int[100005]; //并查集判断是否是一组
    int[] size = new int[100005]; //  sz[i] 标识当前i 左右扩展能有多少个1
    int[] b = new int[100005]; // b[i] 标识 i 位置上是 1, 模拟标识字符串
    int[] cnt = new int[100005]; // 长度为size 有几个

    int find(int x) {
        if (x == par[x]) {return x;}
        else {
            return  par[x] = find(par[x]);
        }
    }

    void merge(int x, int y) {
        int a = find(x), b = find(y);
        if (a  != b) {
            cnt[size[a]]--;
            cnt[size[b]]--;
            par[a] = b;
            size[b]+=size[a];
            cnt[size[b]]++;
        }
    }

    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        char[] str = new char[n];
        for (int i = 1; i <= n; i++) {
            par[i] = i;
            size[i] = 1;
        }
        int index = 1;
        int res = -1;
        for (int i : arr) {
            // b[i] 标识 i 位置上是 1
            b[i] = 1;
            cnt[1]++;
            if (b[i - 1] != 0) {
                merge(i, i - 1);
            }
            if (b[i + 1] != 0) {
                merge(i, i + 1);
            }
            if (cnt[m] != 0) {
                res = index;
            }
            index ++;
        }
        return res;
    }

    int[] prefix;
    public int stoneGameV(int[] s) {
        int n = s.length;
        int[][] dp = new int[n][n];
        prefix = new int[n + 1];
        for (int i = 0 ;i < n; i ++) prefix[i+1] += ( prefix[i] + s[i]);
        for (int i = n - 1; i >= 0 ; i --) {
            for (int j = i+1; j < n; j++) {
                for (int k = i; k < j; k++) {
                    int a = get(i,k), b = get(k+1, j);
                    if (a < b) {
                        dp[i][j] = Math.max(dp[i][j], a + dp[i][k]);
                    } else if (a == b) {
                        dp[i][j] = Math.max(dp[i][j], Math.max(dp[i][k], dp[k +1][j]) + a);
                    } else {
                        dp[i][j] = Math.max(dp[i][j], b + dp[k +  1][j]);
                    }
                }
            }
        }
        return dp[0][n-1];
    }

    int get(int i, int j) {
        return prefix[j + 1] - prefix[i];
    }

    public static void main(String[] args) {
//        System.out.println(mostVisited(7, new int[]{1,3,5,7}));
        System.out.println(maxCoins(new int[]{2,4,1,2,7,8}));
    }

}
