package alg.acwing;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author will
 * @since 2024/5/18
 */
public class P291demo {
    
    public static int INF = Integer.MAX_VALUE;
    
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var n = sc.nextInt();
        var dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = sc.nextInt();
            }
        }
        var res = tsp(dist);
        System.out.println(res);
    }
    
    private static int tsp(int[][] weight) {
        int n = weight.length;
        var dp = new int[1 << n][n];
        for (int i = 0; i < 1 << n; i++) Arrays.fill(dp[i], INF);
        dp[1][0] = 0;
        for (int stat = 2; stat < 1 << n; stat++) {
            // 计算 u 点到 v 点的最短路径长度
            for (int u = 0; u < n; u++) {
                if ((stat >> u & 1) == 1) {
                    for (int v = 0; v < n; v++) {
                        if (u != v && (stat >> v & 1) == 1) {
                            dp[stat][u] = Math.min(
                                    dp[stat][u],
                                    dp[stat - (1 << u)][v] + weight[v][u]
                            );
                        }
                    }
                }
            }
        }
        return dp[(1 << n) - 1][n - 1];
    }
}
