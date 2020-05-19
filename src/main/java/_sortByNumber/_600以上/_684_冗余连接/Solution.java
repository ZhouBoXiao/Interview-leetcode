package _sortByNumber._600以上._684_冗余连接;

public class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int N = edges.length;
        UF uf = new UF(N);
        int[] ans = new int[]{-1,-1};
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            if (!uf.same(u, v)) {
                uf.union(u, v);
            } else {
                ans[0] = u;
                ans[1] = v;
            }

        }
        return ans;
    }
    class UF {

        int[] par, rank;
        UF (int n) {
            par = new int[n +1];
            rank = new int[n +1];
            init(n);
        }

        void init(int n ) {
            for (int i = 0 ; i <= n ; i ++) {
                par[i] = i;
                rank[i] = 0;
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
            if (x == y) return;
            if (rank[x] < rank[y]) {
                par[x] = y;
            } else {
                par[y] = x;
                if (rank[x] == rank[y]) {
                    rank[x]++;
                }
            }
        }
        boolean same(int x, int y) {
            return find(x) == find(y);
        }
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {1,2}, {2,3}, {3,4}, {1,4}, {1,5}
        };
        new Solution().findRedundantConnection(edges);
    }

}