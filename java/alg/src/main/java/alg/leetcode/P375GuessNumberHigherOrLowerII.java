package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/guess-number-higher-or-lower-ii/
 * @author zhangxq
 * @since 2023/6/2
 */
public class P375GuessNumberHigherOrLowerII {
    
    public static void main(String[] args) {
        var solution = new P375GuessNumberHigherOrLowerII();
        solution.getMoneyAmount(Integer.MAX_VALUE);
    }
    
    // 区间 DP 问题
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 2][n + 2];
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i + len - 1 <= n; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i][k - 1], dp[k + 1][j]) + k);
                }
            }
        }
        return dp[1][n];
    }
}
