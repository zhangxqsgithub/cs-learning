package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/interleaving-string/
 * @author zhangxq
 * @since 2023/4/20
 */
public class P97InterleavingString {
    
    public static void main(String[] args) {
    
    }
    
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length();
        if (s3.length() != n + m) return false;
        var dp = new boolean[n + 1][m + 1];
        s1 = " " + s1; s2 = " " + s2; s3 = " " + s3;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 && j == 0) dp[i][j] = true;
                else {
                    if (i != 0 && s1.charAt(i) == s3.charAt(i + j)) {
                        dp[i][j] = dp[i - 1][j];
                    }
                    if (j != 0 && s2.charAt(j) == s3.charAt(i + j)) {
                        dp[i][j] = dp[i][j] || dp[i][j - 1];
                    }
                }
            }
        }
        return dp[n][m];
    }
}
