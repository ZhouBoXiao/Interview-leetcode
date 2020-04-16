package b1.byte01._02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int D = scanner.nextInt();
        int[] location = new int[N];
        for (int i =0 ; i < N ; i++){
            location[i] = scanner.nextInt();

        }
        long cnt = 0L;
        for (int begin = 0, end = 0; end < N; end++) {

            if ( end >= 2 && location[end] - location[begin] > D) {
                begin++;
            }
            //由于判断一次往前移动（for循环中的end++），即可以采用每次固定首位的组合。
            cnt +=  (end - begin) * (end - begin - 1) /2;
        }
        System.out.println(cnt%99997867);
        scanner.close();
    }
}
