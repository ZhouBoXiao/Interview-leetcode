package _sortByNumber._600以上._860_柠檬水找零;

/**
 * @Description:
 * @Author:zhouboxiao@rd.netease.com
 * @Date: 2020/7/24 20:16
 */
public class Solution {
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for(char c : s.toCharArray()){
            index = t.indexOf(c,index+1);
            if(index==-1){
                return false;
            }
        }
        return true;
    }
}
