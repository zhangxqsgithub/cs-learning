package alg.acwing;

import java.util.Scanner;

/**
 * @link https://www.acwing.com/problem/content/4/
 * @author will
 * @since 2024/5/8
 */
public class P4 {
    
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        int n = scan.nextInt(), m = scan.nextInt();
        var v = new int[n];
        var w = new int[n];
        var s = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = scan.nextInt();
            w[i] = scan.nextInt();
            s[i] = scan.nextInt();
        }
        var res = k(n, m, v, w, s);
        System.out.println(res);
    }
    
    /**
     * n 个物品 体积为 m
     * v[i] 表示第 i 个物品的体积
     * w[i] 表示第 i 个物品的价值
     * s[i] 表示可以选择多少个第 i 个物品
     */
    public static int k(int n, int m, int[] v, int[] w, int[] s) {
        var dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                for (int cnt = 1; cnt <= s[i - 1] && j - cnt * v[i - 1] >= 0; cnt++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - cnt * v[i - 1]] + cnt * w[i - 1]);
                }
            }
        }
        return dp[n][m];
    }
}
