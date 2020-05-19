package _公司笔试._阅文;


import java.util.*;


/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/19 19:23
 */
public class Main {
//    public String doQueue (ArrayList<String> ops) {
//        // write code here
//        if (ops == null || ops.size() ==0 ) return "";
//        StringBuilder sb = new StringBuilder();
//        Queue<String> queue = new LinkedList<>();
//        for (String op : ops) {
//            String[] strs = op.split(" ");
//            if ("push".equals(strs[0])) { //push
//                queue.add(strs[1]);
//            } else if ("pop".equals(strs[0])) {//pop
//                if (queue.isEmpty()) sb.append("null").append(",");
//                else sb.append(queue.poll()).append(",");
//            }
//        }
//        if (sb.length() > 0) {
//            return sb.substring(0, sb.length()-1);
//        }
//        return sb.toString();
//    }// 11 13
//     // 14 16
//    // 17 19
//    // 2020-02-01 12:00:00
//    // 0123456789
//
////    public static void main(String[] args) {
////
////        System.out.println(new Main().doQueue(new ArrayList<>(Arrays.asList("push 1", "push 2", "push 3"))));
//////"push 1", "push 2", "pop", "pop", "pop", "push 3"
////    }

    public static void main(String[] args) {
        //System.out.println(new Main().doQueue(new ArrayList<>(Arrays.asList("push 1", "push 2", "pop", "pop", "pop", "push 3"))));

        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        long res = 0;
        int flag = s1.compareTo(s2);
//        if (flag < 0) {
//            String tmp = s1;
//            s1 = s2;
//            s2 = tmp;
//        } else
        if (flag == 0) {
            System.out.println(0);
            return;
        }
        // s1 小  s2 大
        int year1 = Integer.valueOf(s1.substring(0, 4));
        int year2 = Integer.valueOf(s2.substring(0, 4));
        int month1 = Integer.valueOf(s1.substring(5, 7));
        int month2 = Integer.valueOf(s2.substring(5, 7));
        int day1 = Integer.valueOf(s1.substring(8, 10));
        int day2 = Integer.valueOf(s2.substring(8, 10));
        int hour1 = Integer.valueOf(s1.substring(11, 13));
        int hour2 = Integer.valueOf(s2.substring(11, 13));
        int min1 = Integer.valueOf(s1.substring(14, 16));
        int min2 = Integer.valueOf(s2.substring(14, 16));
        int sec1 = Integer.valueOf(s1.substring(17, 19));
        int sec2 = Integer.valueOf(s2.substring(17, 19));
        int temp = day1;
//        boolean flag1 = yea1
        while (month1-- > 0)
            if (month1 == 1 || month1 == 3 || month1 == 5 || month1 == 7 || month1 == 8 || month1 == 10 || month1 == 12) {
                temp += 31;
            } else if (month1 == 2) {

            }
        long res1 = sec1 + min1 * 60 + hour1 * 3600 + day1 * 3600 * 24;
        long res2 = sec2 + min2 * 60 + hour2 * 3600 + day2 * 3600 * 24;
        System.out.println((res2 - res1)/60);

//        if (sec1 > sec2) {
//            if (min2 > 0) {
//                min2--;
//            } else if (hour2 > 0) {
//
//            }
//        }

    }
}
