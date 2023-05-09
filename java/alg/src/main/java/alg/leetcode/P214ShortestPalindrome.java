package alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangxq
 * @link https://leetcode.cn/problems/shortest-palindrome/
 * @since 2023/5/9
 */
public class P214ShortestPalindrome {
    
    public static void main(String[] args) {
    
    }
    
    // 在原字符串中找出一个最长的回文前缀
    public String shortestPalindrome(String s) {
        var t = new StringBuilder(s).reverse();
        var n = s.length();
        s = " " + s + "#" + t;
        var next = new int[n * 2 + 2];
        for (int i = 2, j = 0; i < n * 2 + 2; i++) {
            while (j != 0 && s.charAt(i) != s.charAt(j + 1)) j = next[j];
            if (s.charAt(i) == s.charAt(j + 1)) j++;
            next[i] = j;
        }
        var len = next[n * 2 + 1];
        String left = s.substring(1, 1 + len), right = s.substring(1 + len, 1 + n);
        return new StringBuilder(right).reverse() + left + right;
    }
    
}
