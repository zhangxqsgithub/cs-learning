package alg.acwing;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 滑雪
 *
 * @link https://www.acwing.com/problem/content/903/
 * @author will
 * @since 2024/5/18
 */
public class P901 {
    
    static int n, m;
    static int[][] h;
    static int[][] dp;
    static int[][] dxdy = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    /**
     * 1. dp 子问题：一个格子往上下左右方向滑动，若滑动后下一个格子已经计算得出从该格子
     *    开始滑动的最大值，那么这个格子的最大值 + 1 就是一个可用的结果，求四个方向上所
     *    有可用的结果最大值即可。注意这里滑动到下一个格子要满足高度值小于当前格子，并且
     *    没有出界。
     * 2. dp 数组定义：dp[i][j] 表示从 i, j 开始滑所经过的最大长度
     * 3. dp 方程：往上下左右四个方向滑，例如向右滑动一格即向 h[i][j - 1]
     *    滑动，需要满足 h[i][j] > h[i][j - 1] 并且 i 和 j - 1 在边界内。
     *    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1], dp[i + 1][j], dp[i][j + 1]) + 1
     * 4. 初始化：dp[0][0] = dfs(0, 0)
     * 5. 结果：
     */
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        n = sc.nextInt(); m = sc.nextInt();
        h = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                h[i][j] = sc.nextInt();
            }
        }
        dp = new int[n][m];
        // 全部初始化为 -1 表示每个状态都没有算过
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res = Math.max(res, dfs(i, j));
            }
        }
        System.out.println(res);
    }
    
    private static int dfs(int x, int y) {
        if (dp[x][y] != -1) return dp[x][y];
        // 初始化为 1 最差情况下是可以走当前格子的
        dp[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int a = x + dxdy[i][0], b = y + dxdy[i][1];
            if (valid(a, b) && h[x][y] > h[a][b]) {
                dp[x][y] = Math.max(
                        dp[x][y],
                        dfs(a, b) + 1
                );
            }
        }
        return dp[x][y];
    }
    
    private static boolean valid(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}
