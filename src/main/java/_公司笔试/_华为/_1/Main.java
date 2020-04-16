package _公司笔试._华为._1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String operation = scanner.next();
        String content = scanner.next();
        String []instructs = content.split("],");
        for(String str:instructs){
            if(!str.contains(operation)){
                System.out.println("FAIL");
                continue;
            }
            if(!str.startsWith(operation+"[")){
                System.out.println("FAIL");
                continue;
            }
            str = str.substring(operation.length()+1);
            String []arguments = str.split(",");
            boolean hasAddr = false;
            boolean hasMask = false;
            boolean hasVal = false;
            String []vals = new String[3];
            for(String arg:arguments){
                if(arg.startsWith("addr")){
                    vals[0] = arg.split("=")[1];
                    hasAddr = true;
                }
                if(arg.startsWith("mask")){
                    vals[1] = arg.split("=")[1];
                    hasMask = true;
                }
                if(arg.startsWith("val")){
                    if(arg.contains("]")){
                        arg = arg.substring(0,arg.length()-1);
                    }
                    vals[2] = arg.split("=")[1];
                    hasVal = true;
                }
            }
            if(hasAddr && hasMask && hasVal){
                for(String val:vals){
                    System.out.print(val+" ");
                }
                System.out.println();
            }else{
                System.out.println("FAIL");
            }
        }
    }
}
