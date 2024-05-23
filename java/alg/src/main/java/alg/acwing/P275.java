package alg.acwing;

import java.util.Scanner;

/**
 * 传纸条
 *
 * @link https://www.acwing.com/problem/content/277/
 * @author will
 * @since 2024/5/23
 */
public class P275 {
    
    static int m, n;
    static int[][] w;
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        m = sc.nextInt(); n = sc.nextInt();
        w = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                w[i][j] = sc.nextInt();
            }
        }
        var res = take();
        System.out.println(res);
    }
    
    /**
     * 1. dp 子问题：
     * 2. dp 数组定义：dp[k][i1][i2] 表示走了 k 步后停留在位置 i1,k-i1 和
     *    i2,k-i2 这两个位置上的好心程度之和的最大值。
     * 3. dp 方程：令 j1=k-i1, j2=k-i2，最大值计算为上一步的最大值 + 当前好心程度。
     *    上一步的最大值为：max(dp[k-1][i1-1][i2-1], dp[k-1][i1-1][i2], dp[k-1][i1][i2-1], dp[k-1][i1][i2])
     *    当前好心程度为：
     *    1）若 i1,j2 和 i2,j2 走到一起，也就是 i1=i2 的情况下，好心程度为 w[i1][j1]
     *    2）若 i1,j1 和 i2,j2 没有走到一起，好心程度为 w[i1][j1] + w[i2][j2]
     * 4. 初始化：
     * 5. 结果：dp[m + n][m][m]
     */
    public static int take() {
        var dp = new int[m + n + 1][m + 1][m + 1];
        for (int k = 2; k <= m + n; k++) {
            for (int i1 = Math.max(1, k - n); i1 <= Math.min(k - 1, m); i1++) {
                for (int i2 = Math.max(1, k - n); i2 <= Math.min(k - 1, m); i2++) {
                    int j1 = k - i1, j2 = k - i2;
                    int t = w[i1][j1];
                    if (i1 != i2) t += w[i2][j2];
                    dp[k][i1][i2] = max(
                            dp[k - 1][i1 - 1][i2 - 1],
                            dp[k - 1][i1 - 1][i2],
                            dp[k - 1][i1][i2 - 1],
                            dp[k - 1][i1][i2]
                    ) + t;
                }
            }
        }
        return dp[m + n][m][m];
    }
    
    public static int max(int... n) {
        int res = Integer.MIN_VALUE;
        for (int num : n) res = Math.max(res, num);
        return res;
    }
}
