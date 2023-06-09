package alg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @link https://leetcode.cn/problems/longest-palindrome/
 * @author zhangxq
 * @since 2023/6/9
 */
public class P409LongestPalindrome {
    
    public static void main(String[] args) {
    
    }
    
    // 回文串最多有一个字符是可以为单数的
    public int longestPalindrome(String s) {
        var map = new HashMap<Character, Integer>();
        for (var c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        var res = 0;
        for (var e : map.entrySet()) res += e.getValue() / 2 * 2;
        if (res < s.length()) res++;
        return res;
    }
}
