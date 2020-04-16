package _501_600._567;

import javax.jws.soap.SOAPBinding;
import java.util.*;

public class Solution {

    public boolean checkInclusion(String s1, String s2) {

        int s1_len = s1.length(), s2_len = s2.length();
        if (s1_len > s2_len) return false;
        int[] s1_ch = new int[26], s2_ch = new int[26];

        for (int i = 0; i < s1_len; i++) {
            ++s1_ch[s1.charAt(i) - 'a'];
            ++s2_ch[s2.charAt(i) - 'a'];
        }
        for (int i = s1_len; i < s2_len; i++) {

            if (isEqual(s1_ch, s2_ch)) return true;
            --s2_ch[s2.charAt(i - s1_len) - 'a'];
            ++s2_ch[s2.charAt(i) - 'a'];
        }

        return isEqual(s1_ch, s2_ch);

    }

    private boolean isEqual(int[] s1_ch, int[] s2_ch) {
        for (int i = 0; i < 26; i++) {
            if (s1_ch[i] != s2_ch[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkInclusion("rmqqh", "nrsqrqhrymf"));
    }
}
//"rmqqh"
//"nrsqrqhrymf"
//"trinitrophenylmethylnitramine"
//"dinitrophenylhydrazinetrinitrophenylmethylnitramine"
//"abcdeabcdx"
