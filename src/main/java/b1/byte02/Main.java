package b1.byte02;

import java.util.*;

public class Main {


    public static void main(String[] args) {
        new Main().solution();
    }
    void solution() {
        /*
        作为一个手串艺人，有金主向你订购了一条包含n个杂色串珠的手串——每个串珠要么无色，要么涂了若干种颜色。
        为了使手串的色彩看起来不那么单调，金主要求，手串上的任意一种颜色（不包含无色），在任意连续的m个串珠
        里至多出现一次（注意这里手串是一个环形）。手串上的颜色一共有c种。现在按顺时针序告诉你n个串珠的手串上，
        每个串珠用所包含的颜色分别有哪些。请你判断该手串上有多少种颜色不符合要求。即询问有多少种颜色在任意连续m个
        串珠中出现了至少两次。
         */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();// n个手串

        int m = scanner.nextInt();// 间隔为m

        int c = scanner.nextInt();// 有c种颜色

        Map<Integer, LinkedList<Integer>> map = new HashMap<Integer, LinkedList<Integer>>();

        for(int i = 1; i <= c; i++) {

            map.put(i, new LinkedList<Integer>());

        }

        int total = 1;
        while(total <= n) {

            int num = scanner.nextInt();// 表示有多少顔色

            for(int i = 0; i < num; i++) {

                int color = scanner.nextInt();

                LinkedList<Integer> linkedList = map.get(color);// 得到某種顔色的位置

                linkedList.add(total);// 再加上此位置

                map.put(color, linkedList);

            }

            total++;

        }
        int ans =0 ;
        for (int i = 1 ; i <= c ; i++){
            LinkedList<Integer> linkedList = map.get(i);
            if ( n- linkedList.get(linkedList.size()-1) + linkedList.get(0) < m ){
                ans++;
                continue;
            }
            for (int j = 0; j < linkedList.size()-1; j++){
                if (linkedList.get(j+1) - linkedList.get(j) < m){
                    ans++;
                    break;
                }
            }
        }
        System.out.println(ans);


    }


}