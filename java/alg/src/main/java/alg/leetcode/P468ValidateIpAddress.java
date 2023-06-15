package alg.leetcode;

import java.util.HashSet;

/**
 * @link https://leetcode.cn/problems/validate-ip-address/
 * @author zhangxq
 * @since 2023/6/15
 */
public class P468ValidateIpAddress {
    
    public static void main(String[] args) {
        var solution = new P468ValidateIpAddress();
        var res = solution.validIPv6("2001:0db8:85a3:0:0:8A2E:0370:7334:");
        System.out.println(res);
    }
    
    public String validIPAddress(String ip) {
        if (ip.contains(".") && ip.contains(":")) return "Neither";
        if (ip.contains(".")) return validIPv4(ip);
        if (ip.contains(":")) return validIPv6(ip);
        return "Neither";
    }
    private String validIPv4(String ip) {
        if (ip.charAt(0) == '.' || ip.charAt(ip.length() - 1) == '.') return "Neither";
        var arr = ip.split("\\.");
        if (arr.length != 4) return "Neither";
        for (var x : arr) {
            if (x.isBlank() || x.length() > 3) return "Neither";
            if (x.length() > 1 && x.charAt(0) == '0') return "Neither";
            // 判断一下是否全是数字
            for (var c : x.toCharArray())
                if (!Character.isDigit(c))
                    return "Neither";
            int t = Integer.parseInt(x);
            if (t > 255) return "Neither";
        }
        return "IPv4";
    }
    private String validIPv6(String ip) {
        if (ip.charAt(0) == ':' || ip.charAt(ip.length() - 1) == ':') return "Neither";
        var arr = ip.split(":");
        if (arr.length != 8) return "Neither";
        for (var x : arr) {
            if (x.isBlank() || x.length() > 4) return "Neither";
            for (char c : x.toCharArray())
                if (!Character.isDigit(c) && !('a' <= c && c <= 'f') && !('A' <= c && c <= 'F'))
                    return "Neither";
        }
        return "IPv6";
    }
}
