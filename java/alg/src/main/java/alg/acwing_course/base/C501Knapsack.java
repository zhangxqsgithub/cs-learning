package alg.acwing_course.base;

import java.util.Scanner;

/**
 * 背包问题
 * 有 N 个物品，有一个容量 V 的背包。
 * 第 i 个物品的体积是 vi，价值是 wi。
 * 求解将哪些物品装入背包，可使这些物品的体积不超过背包容量且总价值最大。
 *
 * @author will
 * @since 2024/5/6
 */
public class C501Knapsack {
    
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        int n = scan.nextInt(), m = scan.nextInt();
        var v = new int[n];
        var w = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = scan.nextInt();
            w[i] = scan.nextInt();
        }
        var res = k(n, m, v, w);
        System.out.println(res);
    }
    
    /**
     * DP 子问题：考虑在体积为 y 的情况下的总价值最大情况，若体积为 y，依次选择前 n
     * 个物品，当遇到第 x 个物品时，分为两种情况，
     * 第一种情况：不选择该物品，可能由于体积超过了，也可能由于选择该物品价值并不能最
     * 大化，若不选则该物品则总价值和选择第 x - 1 个物品的总价值是一样的；
     * 第二种情况：选择该物品，选择之后背包体积减少，总价值增加，此时要使用体积为
     * y - v[x] 时最大价值并增加上当前物品 x 的价值即 w[x]
     * 一个物品是否选择就看上面两种情况谁的价值最大。
     * DP 数组定义：dp[i][j] 表示前 i - 1 个物品，总体积是 j 的情况下总价值最大是多少。
     * DP 公式： dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - v[i - 1]] + w[i - 1])
     * 1. 不选择第 i 件物品 dp[i][j] = dp[i - 1][j]
     * 2. 选择第 i 件物品 dp[i][j] = dp[i - 1][j - v[i - 1]] + w[i - 1]
     * 初始化：dp[0][0] = 0 表示在没有选择人物物品的情况下，体积是0，最大总价值为 0。
     * 结果：dp[n][m]
     */
    public static int k(int n, int m, int[] v, int[] w) {
        var dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= v[i - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v[i - 1]] + w[i - 1]);
                }
            }
        }
        return dp[n][m];
    }
    
}
