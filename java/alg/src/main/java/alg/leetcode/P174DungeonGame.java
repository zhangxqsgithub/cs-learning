package alg.leetcode;

import java.util.Arrays;

/**
 * @link https://leetcode.cn/problems/dungeon-game/
 * @author zhangxq
 * @since 2023/5/8
 */
public class P174DungeonGame {
    
    public static void main(String[] args) {
    
    }
    
    public int calculateMinimumHP(int[][] w) {
        int n = w.length, m = w[0].length;
        var dp = new int[n][m];
        for (var i = 0; i < n; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        for (var i = n - 1; i >= 0; i--) {
            for (var j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1) dp[i][j] = Math.max(1, 1 - w[i][j]);
                else {
                    if (i < n - 1) dp[i][j] = dp[i + 1][j] - w[i][j];
                    if (j < m - 1) dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] - w[i][j]);
                    dp[i][j] = Math.max(1, dp[i][j]);
                }
            }
        }
        return dp[0][0];
    }
}
