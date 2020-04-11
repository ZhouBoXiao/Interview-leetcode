package _baidu._3;

import java.util.*;


public class Main {



    public static void main(String[] args) {
        new Main().solution();
    }

    int max = 0;
    private void solution() {

        Scanner s=new Scanner(System.in);
        int N=s.nextInt();
        int[] nums=new int[N+1];
        for (int i = 1; i < N+1; i++) {
            nums[i]=s.nextInt();
        }
        List<Integer>[] graph=new ArrayList[N+1];
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        for (int i = 0; i <N-1 ; i++) {
            int l=s.nextInt();
            int r=s.nextInt();
            graph[l].add(r);
            graph[r].add(l);
        }
        for (int i = 1; i <N ; i++) {
            dfs(graph,nums,i,0);
        }
        System.out.println(max);
    }

    void dfs(List<Integer>[] graph,int[] nums,int now,int len) {

        len+=1;
        max=Math.max(max,len);
        List<Integer> nexts=graph[now];
        for (int next:nexts ) {
            if(nums[next]>nums[now]){
                dfs(graph,nums,next,len);
            }
        }

    }
}
/**
 5
 3 5 5 4 1
 1 2
 1 3
 2 4
 2 5
 */

/**
 4
 1 2 3 4
 1 2
 2 3
 2 4
 */