package alg.leetcode;

import java.util.HashSet;

/**
 * @author zhangxq
 * @link https://leetcode.cn/problems/find-the-closest-palindrome/
 * @since 2023/9/29
 */
public class P564FindTheClosestPalindrome {
    
    public static void main(String[] args) {
    
    }
    
    public String nearestPalindromic(String n) {
        int len = n.length();
        var set = new HashSet<Long>();
        set.add((long) Math.pow(10, len - 1) - 1);
        set.add((long) Math.pow(10, len) - 1);
        long m = Long.parseLong(n.substring(0, (len + 1) / 2));
        for (long i = m - 1; i <= m + 1; i++) {
            var a = String.valueOf(i);
            var b = new StringBuilder(a).reverse();
            if (len % 2 == 1) set.add(Long.parseLong(a + b.substring(1)));
            else set.add(Long.parseLong(a + b));
        }
        
        long k = Long.parseLong(n);
        set.remove(k);
        
        long res = (long) 2e18;
        for (var x : set) {
            if (Math.abs(x - k) < Math.abs(res - k)) {
                res = x;
            }
        }
        return String.valueOf(res);
    }
    
    public String nearestPalindromic2(String n) {
        int len = n.length();
        HashSet<Long> set = new HashSet<>();
        set.add((long) Math.pow(10, len) + 1);
        set.add((long) Math.pow(10, len - 1) - 1);
        long half = Long.parseLong(n.substring(0, (len + 1) / 2));
        for (int i = -1; i <= 1; i++) {
            long val = half + i;
            String next = "";
            if (len % 2 == 0) {
                next = val + "" + new StringBuilder(val + "").reverse();
            }
            else {
                String left = val + "";
                next = val + "" + new StringBuilder(left.substring(0, left.length() - 1)).reverse();
            }
            set.add(Long.parseLong(next));
        }
        long cur = Long.parseLong(n);
        set.remove(cur);
        long min = (long) 1e18;
        long ret = 0;
        for (long num : set) {
            long d = Math.abs(num - cur);
            if (d < min) {
                min = d;
                ret = num;
            }
            else if (d == min && num < ret) {
                ret = num;
            }
        }
        return ret + "";
    }
}
