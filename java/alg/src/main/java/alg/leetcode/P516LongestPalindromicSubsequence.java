package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/longest-palindromic-subsequence/
 * @author zhangxq
 * @since 2023/9/22
 */
public class P516LongestPalindromicSubsequence {
    
    public static void main(String[] args) {
    
    }
    
    /**
     * dp[i][j] 表示字符串 s[i ~ j] 之间的最长回文子序列的长度
     */
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        var dp = new int[n][n];
        for (int len = 1; len <= n; len++) {
            // 从左端点开始枚举
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                // 只有一个字母的时候，最长回文子序列的长度是 1
                if (len == 1) dp[i][j] = 1;
                else {
                    if (s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i + 1][j - 1] + 2;
                    dp[i][j] = Math.max(dp[i][j], Math.max(dp[i + 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[0][n - 1];
    }
    
}
