package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/k-inverse-pairs-array/
 * @author zhangxq
 * @since 2024/2/24
 */
public class P629KInversePairsArray {
    
    public static void main(String[] args) {
    
    }
    
    public int kInversePairs(int n, int k) {
        var mod = (int) 1e9 + 7;
        var dp = new int[n + 1][k + 1];
        dp[1][0] = 1;
        for (int i = 2; i <= n; i++) {
            // 维护前面一段的和
            var s = 0L;
            for (int j = 0; j <= k; j++) {
                s += dp[i - 1][j];
                if (j - i >= 0) s -= dp[i - 1][j - i];
                dp[i][j] = (int) (s % mod);
            }
        }
        return (dp[n][k] + mod) % mod;
    }
}
