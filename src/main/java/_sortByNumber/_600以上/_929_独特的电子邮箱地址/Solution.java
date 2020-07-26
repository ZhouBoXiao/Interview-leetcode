package _sortByNumber._600以上._929_独特的电子邮箱地址;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @Author:zhouboxiao@rd.netease.com
 * @Date: 2020/7/26 22:09
 */
public class Solution {
    public int numUniqueEmails(String[] emails) {
        if(emails.length < 1) return 0;

        Set<String> set = new HashSet<>();
        for(String str : emails){
            String[] strs = str.split("@");
            String sb = strs[0];
            String temp ="";
            for(int i = 0;i < sb.length(); i++){
                if(sb.charAt(i) == '.') continue;
                else if(sb.charAt(i) == '+') break;
                else temp += sb.charAt(i);
            }
            temp += "@"+strs[1];
            set.add(temp);
        }
        return set.size();
    }
}
