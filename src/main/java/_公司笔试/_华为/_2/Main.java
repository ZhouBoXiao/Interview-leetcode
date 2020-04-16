package _公司笔试._华为._2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = scanner.next();
        boolean flag = false;
        String[] strs = s2.split("],");

        for (String s : strs) {
            if (!s.contains(s1)) {
                //System.out.println("FAIL");
                continue;
            }
            if (!s.startsWith(s1 + "[")) {
                //System.out.println("FAIL");
                continue;
            }
            String prefix = s.substring(0, s1.length());
            if (!prefix.equals(s1)) {
                continue;
            }
            s = s.substring(s1.length() + 1);
            String[] ss = s.split(",");
            boolean flag1 = false, flag2 = false, flag3 = false;

            String[] vals = new String[3];
            for (String ss1 : ss) {
                if (ss1.startsWith("addr")) {
                    vals[0] = ss1.split("=")[1];
                    flag1 = true;

                }
                else if (ss1.startsWith("mask")) {
                    vals[1] = ss1.split("=")[1];
                    flag2 = true;
                }
                else if (ss1.startsWith("val")) {
                    //if (ss1.contains("]")) {
                        ss1 = ss1.substring(0, ss1.length() - 1);
                        vals[2] = ss1.split("=")[1];
                        flag3 = true;
                    //}
                }
            }
            if (flag1 && flag2 && flag3) {
                flag = true;

                System.out.println(vals[0] + " " + vals[1] + " " + vals[2] + "\r");

                //System.out.println();
            } /*else {
                System.out.println("FAIL");
            }*/

        }
        if (!flag) {
            System.out.println("FAIL");
        }
    }

    boolean valid2(String s) {
        if (!s.startsWith("0x") && !s.startsWith("0X")) {
            return false;

        }
        for (int i = 0 ; i < s.length(); i++) {
            if (!(s.charAt(i) >= 'A' && s.charAt(i) <= 'F') &&
                    !(s.charAt(i) >= 'a' && s.charAt(i) <= 'f')) {
                    return false;
            }
        }

        return true;
    }

    boolean valid(String s) {
        for (int i = 0 ; i < s.length(); i++) {
            if (s.charAt(i) > 127) {
                return false;
            }
        }
        return true;
    }
}

/**
 read read[addr=0x17,mask=0xff,val=0x7],read_his[addr=0xff,mask=0xff,val=0x1],read[addr=0xf0,mask=0xff,val=0x80]
 */
