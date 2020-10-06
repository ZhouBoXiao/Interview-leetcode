package _题型分类._字符串._验证IP地址;

/**
 * @Description:
 * @Author: boxiao
 * @Date: 2020/9/18 21:58
 */
public class Solution {
    public String validIPAddress(String IP) {
        if (isIPv4(IP)) {
            return "IPv4";
        }
        if (isIPv6(IP)) {
            return "IPv6";
        }
        return "Neither";
    }

    private boolean isIPv4(String IP) {
        if (IP.length() < 7  || IP.charAt(0) == '.' || IP.charAt(IP.length() - 1) == '.') return false;
        String[] strings = IP.split("\\.");
        if (strings.length != 4) return false;
        for (String string : strings) {
            if (string.length() == 0 || (string.charAt(0) == '0' && string.length() != 1)) return false;
            int num = 0;
            for (int i = 0; i < string.length(); i++) {
                char c = string.charAt(i);
                if ( !(c >= '0' && c <= '9')) return false;
                num = num * 10 + c - '0';
                if (num > 255) return false;
            }
        }
        return true;
    }

    private boolean isIPv6(String IP) {
        if (IP.length() < 15 || IP.charAt(0) == ':' || IP.charAt(IP.length() - 1) == ':') {
            return false;
        }
        String[] strings = IP.split(":");
        if (strings.length != 8) {
            return false;
        }
        for (String string : strings) {
            if (string.length() == 0 || string.length() > 4) {
                return false;
            }
            for (int i = 0; i < string.length(); i++) {
                char c = string.charAt(i);
                if (!((c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F') || (c >= '0' && c <= '9'))) {
                    return false;
                }
            }
        }
        return true;
    }
}
