
import java.util.*;
/**
 * @Description:\
 *
 *
 * @Author: boxiao
 * @Date: 2020/9/19 14:53
 */


/*
4
1 2 3 4
 */
public class Main {

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,5,8,0,0} , b = new int[]{4, 7};
        //solve(a, b);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] c = new int[n];

        for (int i = 0; i < n; i++) {
            c[i] = sc.nextInt();
        }
        solve1(n, c);
    }
    static List<List<Integer>> res = new ArrayList<>();

    private static void solve1(int n, int[] array) {
        boolean[] visited = new boolean[n];
        List<Integer> lis = new ArrayList<>();
        dfs(n, array, lis, visited);

        for (List<Integer> list : res) {
            for (int l : list) {
                System.out.print(l + " ");
            }
            System.out.println();
        }
    }

    static void dfs(int n, int[] array, List<Integer> temp, boolean[] vis) {
        if (temp.size() == n) {
            if (check(temp, array)) {
                res.add(new ArrayList<>(temp));
            }
        }

        for (int i = 0; i < n; i++) {
            if (vis[i]) continue;
            temp.add(array[i]);
            vis[i] = true;
            dfs(n, array, temp, vis);
            temp.remove(temp.size() - 1);
            vis[i] = false;
        }

    }

    private static boolean check(List<Integer> temp, int[] c) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0 ; i < c.length; i++) {
            stack.push(c[i]);
            while (!stack.isEmpty() && stack.peek().equals(temp.get(j))) {
                stack.pop();
                j++;
            }
        }
        if (stack.isEmpty()) return true;
        else return false;
    }


    static void solve(int[] a, int[] b) {
        int i = a.length - 1, j = b.length - 1;
        int p = a.length - b.length - 1;

        while (p >= 0 && j >= 0) {
            if (a[p] < b[j]) {
                a[i] = b[j];
                j--;
            } else {
                a[i] = a[p];
                p--;
            }
            i--;
        }
        //while (p >= 0 && i >= 0) a[i--] = a[p--];
        while (j >= 0 && i >= 0) a[i--] = b[j--];

        for (int k = 0; k < a.length; k++) {
            System.out.print(a[k] + " ");
        }
    }
}
