package alg.acwing;

import java.util.Scanner;

/**
 * 最低通行费
 *
 * @link https://www.acwing.com/problem/content/1020/
 * @author will
 * @since 2024/5/21
 */
public class P1018 {
    
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var n = sc.nextInt();
        var w = new int[n + 1][n + 1];
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n; j++) {
                w[i][j] = sc.nextInt();
            }
        }
        var res = cost(w, n);
        System.out.println(res);
    }
    
    /**
     * 1. dp 子问题：从第 1,1 开始走，由于只能走 2n - 1 步所以只能向下或向右走，才能走到终点。
     * 2. dp 数组定义：dp[i][j] 表示走到 i,j 这一步所用到的最少费用。
     * 3. dp 方程：dp[i][j] += min(dp[i - 1][j], dp[i][j - 1])
     * 4. 初始化：dp[1][1] = w[1][1], dp[0][i] = dp[i][0] = int_max, dp[0][1]=dp[1][0]=0
     * 5. 结果：dp[n][n]
     */
    public static int cost(int[][] w, int n) {
        var dp = w;
        for (int i = 1; i <= n; i++) {
            dp[0][i] = Integer.MAX_VALUE;
            dp[i][0] = Integer.MAX_VALUE;
        }
        dp[0][1] = dp[1][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] += Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n][n];
    }
}
