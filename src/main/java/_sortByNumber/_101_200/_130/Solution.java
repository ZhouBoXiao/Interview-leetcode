package _sortByNumber._101_200._130;

public class Solution {

    public void solve(char[][] board) {

        int m = board.length ;
        if (m == 0) return;
        int n = board[0].length;
        if (n == 0) return;

        int dummy = m * n;
        UnionFind unionFind = new UnionFind(dummy + 1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                        unionFind.union(i * n + j, dummy);
                    } else {
                        if (board[i - 1][j] == 'O')
                            unionFind.union((i-1)*n + j, i*n+j);
                        if (board[i][j - 1] == 'O')
                            unionFind.union(i*n + j - 1, i*n+j);
                        if (i < m-1 && board[i+1][j] == 'O')
                            unionFind.union((i+1)*n + j, i*n+j);
                        if (j < n-1 && board[i][j+1] == 'O')
                            unionFind.union(i*n + j+1, i*n+j);
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!unionFind.isConnected(i*n+j, dummy))
                    board[i][j] = 'X';
            }
        }
//        Arrays.asList(board).forEach(System.out::println);

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
    // 合并连通区域是通过find来操作的, 即看这两个节点是不是在一个连通区域内.
    void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);
        if (root1 != root2) {
            parents[root2] = root1;
        }
    }

    int find(int node) {
        while (parents[node] != node) {
            // 当前节点的父节点 指向父节点的父节点.
            // 保证一个连通区域最终的parents只有一个.
            parents[node] = parents[parents[node]];
            node = parents[node];
        }

        return node;
    }

    boolean isConnected(int node1, int node2) {
        return find(node1) == find(node2);
    }
}
