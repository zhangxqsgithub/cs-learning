package alg.acwing;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 最短 Hamilton 路径
 * Hamilton 路径的定义是从 0 到 n − 1 不重不漏地经过每个点恰好一次。
 *
 * @link https://www.acwing.com/problem/content/93/
 * @author will
 * @since 2024/5/17
 */
public class P91 {
    
    // 定义一个非常大的数，表示“无穷大”
    private static final int INF = Integer.MAX_VALUE / 2;
    
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
    
    /**
     * 1. dp 子问题：
     * 2. dp 数组定义：
     * 3. dp 方程：dp[stat][u] 使用 stat 中的二进制数字表示哪些点被用过，0 表示未使用 1
     *    表示已使用，u 表示最后停在第 u 个点上，状态为 mask 并且最后一个点停留在第 u 个点
     *    上的最短路径长度。
     * 4. 初始化：
     * 5. 结果：
     */
    public static int tsp(int[][] dist) {
        var n = dist.length;
        var dp = new int[1 << n][n];
        
        // 初始化 dp 数组，所有值都设为无穷大
        for (int[] row : dp) Arrays.fill(row, INF);
        // 从城市 0 开始，初始状态是只访问了城市 0
        dp[1][0] = 0;
        // 遍历所有状态
        for (int stat = 1; stat < (1 << n); stat++) {
            for (int u = 0; u < n; u++) {
                if ((stat >> u & 1) == 1) {
                    for (int v = 0; v < n; v++) { // 计算 u 点到其他点的最短路径
                        if ((stat - (1 << u) >> v & 1) == 1) {
                            dp[stat][u] = Math.min(
                                    dp[stat][u],
                                    dp[stat - (1 << u)][v] + dist[v][u]
                            );
                        }
                    }
                }
            }
        }
        return dp[(1 << n) - 1][n - 1];
    }
}
