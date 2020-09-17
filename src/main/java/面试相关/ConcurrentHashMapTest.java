package 面试相关;


import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentHashMapTest {
    private static final int _1MB = 1024 * 1024;

    /**
     *
     * VM 参数 ： -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:SurvivorRatio=8 -Xloggc:gc.log
     */

    public static  void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[2 * _1MB];  //出现一次Minor GC
    }
    public static void main(String[] args) {
        testAllocation();

        //new HashMap<>()
            ConcurrentMap<String, String> stringStringConcurrentHashMap = new ConcurrentHashMap<>();

    }

}
