package alg.leetcode;

import java.util.Arrays;

/**
 * @link https://leetcode.cn/problems/freedom-trail/
 * @author zhangxq
 * @since 2023/9/18
 */
public class P514FreedomTrail {
    
    public static void main(String[] args) {
        var solution = new P514FreedomTrail();
        var res1 = solution.findRotateSteps("godding", "gd");
        System.out.println(res1);
    }
    
    /**
     * 用 DP 做
     * DP 子问题：
     * DP 数组定义：已经输出了 key 的前 i 个字符，且输出 key[i] 时指针到达 ring[j] 的所有方案
     * DP 方程：
     * 初始化：
     * 结果：所有方案里的最小值
     */
    public int findRotateSteps(String ring, String key) {
        int max = 100_000;
        int n = ring.length(), m = key.length();
        // 为了计算方便在字符串前面增加一个字符
        ring = " " + ring; key = " " + key;
        
        var dp = new int[m + 1][n + 1];
        // 初始化
        for (int i = 0; i <= m; i++) Arrays.fill(dp[i], max);
        dp[0][1] = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 若 dp[i][j] 可能成立的话，前提是 key[i] == ring[j]
                if (key.charAt(i) == ring.charAt(j)) {
                    for (int k = 1; k <= n; k++) {
                        int t = Math.abs(k - j);
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.min(t, n - t) + 1);
                    }
                }
            }
        }
        
        int res = max;
        for (int i = 1; i <= n; i++) res = Math.min(res, dp[m][i]);
        return res;
    }
}
