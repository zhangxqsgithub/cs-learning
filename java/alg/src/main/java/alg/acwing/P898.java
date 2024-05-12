package alg.acwing;

import java.util.Scanner;

/**
 * @link https://www.acwing.com/problem/content/900/
 * @author will
 * @since 2024/5/12
 */
public class P898 {
    
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        var s = new int[n][n];
        for (int i = 1; i <= n; i++)
            for (int j = 0; j < i; j++)
                s[i - 1][j] = sc.nextInt();
        /*
        从下到上考虑，少特判
        dp 分析
        1. dp 子问题
           从下到上考虑，到每一个节点所走的路径最大值是从叶节点走到左边节点所有路径的最大值
           和从叶节点走到右边路径所有路径的最大值，两者取其大者。
        2. dp 数组定义
           dp 数组保存从叶节点到某个节点路径和的最大值。
           所有从叶节点到 dp[i][j] 节点路径和的最大值。
        3. dp 方程
           从下到上考虑，要么左边值加 s[i][j] 是最大值，要么右边值加 s[i][j] 是最大值
           dp[i][j] = max(dp[i + 1][j], dp[i + 1][j + 1]) + s[i][j]
        4. 初始化
           从下到上考虑，下面需要多申请一行和一列数组
           new dp[n + 1][m + 1]
        5. 结果 从下到上遍历 dp[0][0]
         */
        var dp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j + 1]) + s[i][j];
            }
        }
        System.out.println(dp[0][0]);
    }
    
    
}
