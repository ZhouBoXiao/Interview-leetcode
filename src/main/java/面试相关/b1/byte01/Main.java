package 面试相关.b1.byte01;

import java.util.*;

public class Main {


    public static void main(String[] args) {
        new Main().solution();
    }
    void solution() {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] h = new int[N];

        int max= 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0 ; i < N ;i++){
            h[i] = scanner.nextInt();
            if (!map.containsKey(h[i])) {
                List<Integer> l = new ArrayList<>();
                l.add(i+1);
                map.put(h[i], l);
            }else{
                map.get(h[i]).add(i+1);
            }
        }
        int m = scanner.nextInt();
        int[] ans = new int[m];
        for (int i = 0 ;i< m ;i++){
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int k = scanner.nextInt();
            if (map.containsKey(k)) {
                ans[i] = find(map, l, r, k);
            }else {
                ans[i] = 0;
            }
        }

        for (int an : ans) {
            System.out.println(an);
        }

    }

    private int find(Map<Integer, List<Integer>> map, int l, int r, int k) {

        List<Integer> q = map.get(k);
        int left = 0 ,right = q.size()-1;
        int res = 0;
        while(left<=right){
            int mid = (left + right)/2;
            if (q.get(left) > r || q.get(right) < l)
                break;
            else if (q.get(mid) > r ){
                right = mid;
            }
            else if (q.get(mid) <l){
                left = mid + 1;
            }
            else if (q.get(mid) >= l && q.get(mid) <= r){
                for (int i =left ;i <=right ; i++){
                    if (q.get(i) > r){
                        break;

                    }
                    else if(q.get(i) >= l && q.get(i) <= r ) {
                        res++;
                    }
                }
                break;
            }

        }
        return res;
    }


}

/*

Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int c = scanner.nextInt();

        List<Integer>[] lists = new List[5];
        for (int i = 0 ; i < n ;i++){
            int num_i = scanner.nextInt();

            for (int j = 0 ;j <num_i ; j++) {
                lists[i].add(scanner.nextInt());
            }

        }



        for (int i = 0 ;i< m ;i++){

        }

        for (int an : ans) {
            System.out.println(an);
        }
int[] v = new int[]{64, 16, 4 ,1};

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int m = 1024 - N;
        int total = 0;
        for (int i = 0 ; i < 4 ;i++){
            int t = m/v[i];
            m-= t * v[i];
            total+=t;
        }
        System.out.println(total);
void solution(){
        int max = 1;
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        for (int i =0 ; i < N; i ++ ){
            List<Map<Integer,Integer>> list = new ArrayList<>();
            Map<Integer,Integer> map = new HashMap<>();
            for (int j =0 ; j< M ; j++){
                int S = scanner.nextInt();
                Set<Integer> temp = new HashSet<Integer>(map.keySet());
                for (int k = 0 ;k < S; k++){
                    int x = scanner.nextInt();
                    int y = scanner.nextInt();
                    int x_y = Objects.hash(x, y);

                    if (!map.containsKey(x_y)){
                        map.put(x_y,1);
                        temp.remove(x_y);
                    }
                    else{
                        map.put(x_y, map.get(x_y)+1);
                        temp.remove(x_y);
                        if (max < map.get(x_y)){
                            max = map.get(x_y);
                        }
                    }
                }
                for (Integer in : temp){
                    map.put(in, 0);
                }
                list.add(map);
            }
        }
        System.out.println(max);



    }
int min = Integer.MAX_VALUE;

    int N;
    public static void main(String[] args) {
        new _题型分类._二叉树.Main().solution();
    }

    void solution(){
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        int[][] cities = new int[N][N];

        for (int i = 0 ;i < N; i++){
            for (int j = 0 ;j < N; j++){
                cities[i][j] = scanner.nextInt();
            }
        }
        scanner.close();
        int V = 1 << (N-1);
        int[][] dp = new int[N][V];

        for (int i =0 ;i < N ; i++){
            dp[i][0] = cities[i][0];
        }


        //设想一个数组城市子集V[j]，长度为V,且V[j] = j,对于V[j]即为压缩状态的城市集合
        //从1到V-1  用二进制表示的话，刚好可以映射成除了0号城市外的剩余n-1个城市在不在子集V[j]，1代表在，0代表不在
        //若有总共有4个城市的话，除了第0号城市，对于1-3号城市
        //111 = V-1 = 2^3 - 1  = 7 ，从高位到低位表示3到1号城市都在子集中
        //而101 = 5 ，表示3,1号城市在子集中，而其他城市不在子集中
        //这里j不仅是dp表的列坐标值，如上描述，j的二进制表示城市相应城市是否在子集中
        for ( int j = 1; j < V; j++){

            for ( int i = 0 ; i < N; i ++){ //这个i不仅代表城市号，还代表第i次迭代
                dp[i][j] = Integer.MAX_VALUE;
                if(((j>>(i-1)) & 1)== 0 ){

                    // 因为j就代表城市子集V[j],((j >> (i - 1))是把第i号城市取出来
                    //并位与上1，等于0，说明是从i号城市出发，经过城市子集V[j]，回到起点0号城市
                    for (int k =1 ; k < N; k ++){ // 这里要求经过子集V[j]里的城市回到0号城市的最小距离
                        if ( (j^(1<<(k-1))) == 1){ //遍历城市子集V[j]

                            //设s=j ^ (1 << (k - 1))
                            //dp[k][j ^ (1 << (k - 1))，是将dp定位到，从k城市出发，经过城市子集V[s]，回到0号城市所花费的最小距离
                            //怎么定位到城市子集V[s]呢，因为如果从k城市出发的，经过城市子集V[s]的话
                            //那么V[s]中肯定不包含k了，那么在j中把第k个城市置0就可以了，而j ^ (1 << (k - 1))的功能就是这个
                            dp[i][j] = Math.min(dp[i][j], dp[k][j^(1<<(k-1))] + cities[i][k]);
                        }
                    }
                }
            }
        }
        System.out.println(dp[0][V - 1]);


    }

     void dfs(int cost, boolean[][] visited, int[][] cities, int from, int total){

        if (total == N ) {
            if (from == 0 && cost < min) {
                min = cost;
            }else{
                return;
            }
        }
        for (int i = 0 ; i < N; i ++){
            if (i!=from && !visited[from][i]){

                visited[from][i] = true;
                visited[i][from] = true;
                dfs(cost + cities[from][i], visited,cities, i, total+1);
                visited[from][i] = false;
                visited[i][from] = false;
            }

        }
    }

   // public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] cards = new int[10];
        int[] state = new int[10];
        List<Integer> ret = new ArrayList<>();
        for (int i =1 ; i <= 13 ; i++){
            state[scanner.nextInt()]++;
        }
        for (int i =1 ; i <= 9 ;i ++){
            if (cards[i] < 4) {
                System.arraycopy(state, 1, cards, 1, 9);
                cards[i]++;
                if (ok(cards, 14, false)) {
                    ret.add(i);
                }
            }

        }
        if (ret.size() ==0 ){
            System.out.println(0);
        }
        else {
            for (int i = 0; i < ret.size(); i++) {
                if (i == ret.size() - 1)
                    System.out.println(ret.get(i));
                else {
                    System.out.print(ret.get(i) + " ");
                }
            }
        }

    }

    private static boolean ok(int[] cards, int total, boolean hasHead) {
        if (total == 0)
            return true;
        if (!hasHead){
            for ( int i = 1 ;i <= 9 ; i ++){
                if (cards[i] >=2){
                    cards[i] -=2;
                    if (ok(cards, total-2,true)){
                        return true;
                    }
                    cards[i]+=2;
                }
            }

        }else{
            for ( int i =1 ;i <= 9 ; i ++){
                if (cards[i] > 0){
                    if (cards[i] >=3){
                        cards[i]-=3;
                        if (ok(cards, total-3,true))
                            return true;
                        cards[i]+=3;
                    }
                    if (i +2 <= 9 && cards[i+1] > 0 && cards[i+2] > 0){

                        cards[i]-=1;
                        cards[i+1]-=1;
                        cards[i+2]-=1;
                        if (ok(cards, total-3, true))
                            return true;

                        cards[i]+=1;
                        cards[i+1]+=1;
                        cards[i+2]+=1;
                    }
                }

            }
        }
        return false;
    }

public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int D = scanner.nextInt();
        int[] location = new int[N];
        for (int i =0 ; i < N ; i++){
            location[i] = scanner.nextInt();

        }
        long cnt = 0L;
        for (int i =0, j=1; i <N -2 ; i++){

            while(j<N && location[j] - location[i] <= D) j++;
            j--;
            if(j-i>=2)
                cnt += (j-i-1) * (j-i)/2;
            if (cnt > 99997867) {
                cnt %= 99997867;
            }


        }
        System.out.println(cnt);
    }
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        for (int i =0 ;i < N ; i++){
            String s = scanner.next();
            int times =1;
            for (int j = 1 ;j <s.length() ; j++){

                if (s.charAt(j) == s.charAt(j-1)){
                    times++;
                }else{
                    times = 1;
                }
                if(times >= 3){
                    s= s.substring(0, j)+s.substring(j+1);
                    j--;
                }
                else if (times == 2){
                    if (j >= 3 && s.charAt(j-3) == s.charAt(j-2)){
                        s= s.substring(0, j)+s.substring(j+1);
                        j--;
                    }
                }

            }

            System.out.println(s);
        }



    }
 */