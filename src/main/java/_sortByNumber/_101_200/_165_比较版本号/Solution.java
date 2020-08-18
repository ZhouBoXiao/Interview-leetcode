package _sortByNumber._101_200._165_比较版本号;

/**
 * @Description:
 * @Author:zhouboxiao@rd.netease.com
 * @Date: 2020/7/26 22:00
 */
public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] a1 = version1.split("\\.");
        String[] a2 = version2.split("\\.");

        for(int n = 0; n < Math.max(a1.length, a2.length); n++){
            int i = (n < a1.length ? Integer.parseInt(a1[n]) : 0);
            int j = (n < a2.length ? Integer.parseInt(a2[n]) : 0);
            if(i < j) return -1;
            else if(i > j) return 1;
        }
        return 0;
    }
}
