package _mt._1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Main {
    static class Edge{
        int from, to, cost;
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Edge[] edges = new Edge[n+1];
        for (int i = 0; i < n - 1; i++) {
            edges[i] =  new Edge();
            edges[i].from = scanner.nextInt();
            edges[i].to = scanner.nextInt();
            edges[i].cost = scanner.nextInt();
        }
        int disRes = 0;
        Set<Integer> ingore = new HashSet<>();
        int[][] dis = new int[n][2];
        for (int i = 0; i < n - 1; i++) {
            if (edges[i].from == 1) {
                disRes += edges[i].cost;
                dis[i][1] = edges[i].cost;
                dis[i][0] = edges[i].to;
            } else {
                Set<Integer> ig = new HashSet<>();
                for (int j =  0; j < n - 1; j++) {
                    if (edges[j].from == 1 ) {
                        int temp = dfs(edges, edges[j].to, n, edges[i].to, ig);
                        if (temp < 0) {
                            ig.clear();
                            continue;
                        }
                        ingore.addAll(ig);
                        temp += edges[j].cost;
                        disRes +=  temp;
                        dis[i][1] = temp;
                        dis[i][0] = edges[i].to;
                        break;
                    }
                }
            }
        }
        boolean[] vis = new boolean[n];
        Arrays.sort(dis, (o1,o2)-> o2[1] - o1[1]);
        int ans  = 0 ;
        for (int i = 0; i < n - 1; i++) {
            if (i == 0) {
                ans += dis[i][1];
                continue;
            }
            int end = dis[i][0];
            if (ingore.contains(end)) {
                continue;
            } else {
                ans += dis[i][1] * 2;
            }
        }
        System.out.println(disRes + " " + ans);
    }
    static int dfs(Edge[] edges, int to, int n, int end, Set<Integer> ig) {
        if (to == end) {
            return 0;
        }
        for (int j =  1; j < n; j++) {
            if (edges[j].from == to) {
                ig.add(to);
                return edges[j].cost +  dfs(edges, edges[j].to, n, end, ig);
            }
        }
        return Integer.MIN_VALUE;
    }
}
/*

5
1 2 3
1 3 1
1 4 2
2 5 1

 */