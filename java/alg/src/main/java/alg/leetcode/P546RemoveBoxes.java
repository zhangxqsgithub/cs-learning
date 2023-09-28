package alg.leetcode;

import java.util.Arrays;

/**
 * @link https://leetcode.cn/problems/remove-boxes/
 * @author zhangxq
 * @since 2023/9/27
 */
public class P546RemoveBoxes {
    
    public static void main(String[] args) {
    
    }
    
    /**
     * dp 子问题：
     * 状态转移方程：
     * dp 数组定义：
     * dp 数组初始化：
     * 结果：
     */
    public int removeBoxes(int[] boxes) {
        int n = boxes.length, INF = 0x7ffffff0;
        var dp = new int[n][n][n + 1];
        // 初始化为负无穷
        for (var arr1 : dp) for (int[] arr2 : arr1) Arrays.fill(arr2, -INF);
        // 定义 g 数组
        var g = new int[n][n];
        for (var arr1 : g) Arrays.fill(arr1, -INF);
        
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                for (int k = 1; k <= len; k++) {
                    if (len == 1) dp[i][j][k] = 1;
                    else if (k == 1) dp[i][j][k] = 1 + g[i + 1][j];
                    else {
                        for (int u = i + 1; u <= j - k + 2; u++) {
                            // 表示 i 和 u 不能同时被删除
                            if (boxes[i] != boxes[u]) continue;
                            int t = 0;
                            if (i + 1 <= u - 1) t = g[i + 1][u - 1];
                            dp[i][j][k] = Math.max(dp[i][j][k], t + dp[u][j][k - 1] - (k - 1) * (k - 1) + k * k);
                        }
                    }
                    g[i][j] = Math.max(g[i][j], dp[i][j][k]);
                }
            }
        }
        return g[0][n - 1];
    }
}
