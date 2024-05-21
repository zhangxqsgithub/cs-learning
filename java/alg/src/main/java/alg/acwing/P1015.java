package alg.acwing;

import java.util.Scanner;

/**
 * 摘花生
 *
 * @link https://www.acwing.com/problem/content/1017/
 * @author will
 * @since 2024/5/21
 */
public class P1015 {
    
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int q = sc.nextInt();
        while (q-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt();
            var matrix = new int[n + 1][m + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            var res = pick(matrix, n, m);
            System.out.println(res);
        }
    }
    
    /**
     * 1. dp 子问题：走到第 i,j 个位置上采摘花生的最大结果为，走到 i-1,j 和
     *    i,j-1 两个的最大值 + matrix[i][j]
     * 2. dp 数组定义：dp[i][j] 表示走到 i,j 这各位所能采摘到花生的最大值
     * 3. dp 方程：dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j];
     * 4. 初始化：dp[1][1] = matrix[1][1]
     * 5. 结果： dp[n][m]
     */
    public static int pick(int[][] matrix, int n, int m) {
        var dp = matrix;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] += Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n][m];
    }
}
