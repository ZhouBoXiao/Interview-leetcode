package _美团笔试._1;
import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        BigDecimal a1 = new BigDecimal(0);
        BigDecimal a2 = new BigDecimal(0);
        BigDecimal a3 = new BigDecimal(0);

        for(int i = 0; i < n; i++) {

            BigDecimal tmp = new BigDecimal(scanner.next());
            if (i == 0) {
                a1 = tmp;
                continue;
            }
            if (i == 1) {
                if (tmp.compareTo(a1) > 0) {
                    a2 = a1;
                    a1 = tmp;
                }
                else {
                    a2 = tmp;
                }
                continue;
            }if (i == 2) {
                if (tmp.compareTo(a1) > 0) {
                    a3 = a2;
                    a2 = a1;
                    a1 = tmp;
                } else if (tmp.compareTo(a2) > 0){
                    a3 = a2;
                    a2 = tmp;
                } else {
                    a3 = tmp;
                }
                continue;
            }
            if (tmp.compareTo(a3) > 0 && tmp.compareTo(a2) < 0) {

                a3 = tmp;
            } else if (tmp.compareTo(a2) > 0 && tmp.compareTo(a1) < 0) {
                a3 = a2;
                a2 = tmp;

            } else if (tmp.compareTo(a1) > 0 ){
                a3 = a2;
                a2 = a1;
                a1 = tmp;
            }

        }

        BigDecimal b1 = new BigDecimal(0);
        BigDecimal b2 = new BigDecimal(0);
        BigDecimal b3 = new BigDecimal(0);
        for(int i = 0; i < n; i++) {

            BigDecimal tmp = new BigDecimal(scanner.next());
            if (i == 0) {
                b1 = tmp;
                continue;
            }
            if (i == 1) {
                if (tmp.compareTo(b1) > 0) {
                    b2 = b1;
                    b1 = tmp;
                }
                else {
                    b2 = tmp;
                }
                continue;
            }if (i == 2) {
                if (tmp.compareTo(b1) > 0) {
                    b3 = b2;
                    b2 = b1;
                    b1 = tmp;
                } else if (tmp.compareTo(b2) > 0){
                    b3 = b2;
                    b2 = tmp;
                } else {
                    b3 = tmp;
                }
                continue;
            }
            if (tmp.compareTo(b3) > 0 && tmp.compareTo(b2) < 0) {

                b3 = tmp;
            } else if (tmp.compareTo(b2) > 0 && tmp.compareTo(b1) < 0) {
                b3 = b2;
                b2 = tmp;

            } else if (tmp.compareTo(b1) > 0 ){
                b3 = b2;
                b2 = b1;
                b1 = tmp;
            }

        }
        BigDecimal a = a1.add(a2).add(a3);
        BigDecimal b = b1.add(b2).add(b3);

        if (a.compareTo(b) > 0) {
            System.out.println(a.toString());
        } else {
            System.out.println(b.toString());
        }
    }
}
