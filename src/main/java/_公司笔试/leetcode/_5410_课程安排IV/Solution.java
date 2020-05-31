package _公司笔试.leetcode._5410_课程安排IV;

import org.apache.zookeeper.data.Stat;

import java.util.*;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/30 23:21
 */
public class Solution {

    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        int[] flags = new int[n];
        boolean[][] d = new boolean[105][105];
        List<Boolean> res =  new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++)d[i][i]=true;
        for (int[] p : prerequisites) {
            d[p[0]][p[1]] = true;
        }
        for(int k=0;k<n;k++)
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++) {
                    d[i][j]=d[i][j]||d[i][k]&&d[k][j];
                }
        for (int[] p : queries) {
            res.add(d[p[0]][p[1]]);
        }
        return res;
    }


    public static void main(String[] args) {

    }
}
