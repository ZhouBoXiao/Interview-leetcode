package _公司笔试._阅文._1;

import java.util.*;
/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/19 20:17
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            String[] strs = s.split(",");
            for (int j = 0; j < n; j++) {
                if (j!= i) {
                    if ("1".equals(strs[j])){
                        if (!uf.isSame(i,j))
                            uf.union(i,j);
                    }
                }
            }
        }
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < uf.parents.length; i++) {
            set.add(uf.parents[i]);
        }
        System.out.println(set.size());
    }
}
class UnionFind {
    int[] parents;

    public UnionFind(int totalNodes) {
        parents = new int[totalNodes];
        for (int i = 0; i < totalNodes; i++) {
            parents[i] = i;
        }
    }
    void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);
        if (root1 != root2) {
            parents[root2] = root1;
        }
    }

    int find(int node) {
        while (parents[node] != node) {
            parents[node] = parents[parents[node]];
            node = parents[node];
        }
        return node;
    }

    boolean isSame(int node1, int node2) {
        return find(node1) == find(node2);
    }
}
