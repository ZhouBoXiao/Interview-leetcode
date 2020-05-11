package _600以上._765_情侣牵手;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/11 22:23
 */
public class Solution {

    private int[] parent;
    public int minSwapsCouples1(int[] row) {
        int n = row.length;
        parent = new int[n];
        for (int i = 0; i < n; i+= 2) {
            parent[i] = i;
            parent[i +  1] = i;
        }
        for (int i = 0; i < n; i += 2) {
            union(row[i], row[i+1]);
        }
        int res = n /2;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                res--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().minSwapsCouples1(new int[]{0, 2, 1, 3});
    }
    private int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }
    private void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) {
            return;
        }
        parent[x] = y;
    }


    // 迭代
    public int minSwapsCouples(int[] row) {
        int res = 0;
        for (int i = 0; i <row.length; i+=2) {
            int t = row[i] ^ 1;
            if (row[i+1] == t) {
                continue;
            }
            res++;
            for (int j = i+1; j < row.length; j++) {
                if (row[j] == t) {
                    row[j] = row[i+1];
                    row[i+1] = t;
                    break;
                }
            }
        }
        return res;
    }
}
