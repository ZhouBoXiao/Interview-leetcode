package _公司笔试._华为._3;

import java.util.*;

public class Main {
    static int max = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        String seee = scanner.nextLine();

        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] nums = new int[n + 1];
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0 ; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        String s;
        scanner.nextLine();
        for (int i = 0 ; i < n; i++) {
            s = scanner.nextLine();
            //int cnt = 0;
            /*if (scanner.hasNext()) {
                List<Integer> list = new ArrayList<>();
                nums[i] = scanner.nextInt();
                for (int j = 0 ; j < a[i] ; j ++)  {
                    list.add(scanner.nextInt());
                }
                lists.add(list);
            } else {
                System.out.println("NA");
                return;
            }*/

//            if (nums[i] == 0)
            String[] strs = s.split( " ");
            if (strs.length < a[i] + 2) {
                System.out.println("NA");
                return;
            }
            //int tmp = scanner.nextInt();
            List<Integer> list = new ArrayList<>();

            nums[i] = Integer.parseInt(strs[1]);
            for (int j = 0 ; j < a[i] ; j ++) {
                list.add(Integer.parseInt(strs[j+2]));
            }
            lists.add(list);
        }
        int[] visited = new int[n];
        for (int i = 0 ; i < n; i++) {
            //visited[i] = -1;
            dfs(lists, i, 0, nums, visited);
            //visited[i] = 0;
        }


        System.out.println(max);
        scanner.close();
    }

    static void dfs(List<List<Integer>> lists, int cur, int sum, int[] nums, int[] visited) {
        if (lists.get(cur).size() == 0 ) {
            sum += nums[cur];
            if (sum > max) {
                max = sum;

            }
            return;
        }
        if (lists.get(cur).size() > 0 ) {
            sum += nums[cur];
        }
        for (int i = 0 ; i < lists.get(cur).size(); i++) {
            if (visited[lists.get(cur).get(i) - 1] == -1) {
                return;
            }
            //sum +=  nums[lists.get(cur).get(i) - 1];
            visited[lists.get(cur).get(i) - 1] --;
            dfs(lists, lists.get(cur).get(i) - 1, sum, nums, visited);
            visited[lists.get(cur).get(i) - 1] ++;
            //sum -=  nums[lists.get(cur).get(i) - 1];
        }

    }
}
/*
5 2 3 1 1 0
1 20 2 3
2 30 3 4 5
3 50 4
4 60 1
5 80

5 2 3 1 0 0
1 20 2 3
2 30 3 4 5
3 50 4
4 60
5 80

 */