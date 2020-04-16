package _公司笔试._alibaba._2;
import java.util.*;

class Node {
    int x, y, t, step;
    Node (int x, int y, int t, int step) {
        this.x = x;
        this.y = y;
        this.t = t;
        this.step = step;
    }
}


public class Main {

    int N = 505;
    boolean[][][] vis = new boolean[N][N][6];
    int n, m, sx, sy, tx, ty;
    char[][] maze = new char[N][N];
    int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    void solution() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String[] tmp = scanner.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                maze[i][j] = tmp[j].charAt(0);
                if (maze[i][j] == 'S') {
                    sx = i;
                    sy = j;
                    maze[i][j] = '.';
                } else if (maze[i][j] == 'E') {
                    tx = i;
                    ty = j;
                    maze[i][j] = '.';
                }
            }
        }
        System.out.println(bfs());
    }

    int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(sx, sy, 0, 0));
        vis[sx][sy][0] = true;
        while (!q.isEmpty()) {
            Node now = q.poll();
            if (now.x == tx && now.y == ty){
                return now.step;
            }
            for (int i = 0; i < 4; i++) {
                int xx = now.x + dir[i][0], yy = now.y + dir[i][1];
                if (!judge(xx, yy) || vis[xx][yy][now.t]) {
                    continue;
                }
                vis[xx][yy][now.t] = true;
                q.offer(new Node(xx, yy, now.t, now.step+1));
            }
            int xx = n - 1 - now.x, yy = n - 1 - now.y;
            if (!judge(xx, yy) || vis[xx][yy][now.t+1] || now.t == 5) {
                continue;
            }
            vis[xx][yy][now.t+1] = true;
            q.offer(new Node(xx, yy, now.t+1, now.step+1));
        }
        return -1;

    }

    private boolean judge(int x, int y) {
        if (x < 0 | x >= n || y < 0 || y >= m || maze[x][y] == '#'){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new Main().solution();
    }
}