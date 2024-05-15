package alg.acwing;

import java.util.Scanner;

/**
 * 整数划分
 *
 * @link https://www.acwing.com/problem/content/902/
 * @author will
 * @since 2024/5/14
 */
public class P900 {
    
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var n = sc.nextInt();
        var mod = (int) Math.pow(10, 9) + 7;
        /*
        1. dp 子问题：
        2. dp 数组定义：dp[i][j] 表示和是 i 并且恰好表示成 j 个数相加的方案数量
        3. dp 方程 动态转移方程：dp[i][j] = dp[i - 1][j - 1] + dp[i - j][j]
           方案中最小值是 1 的：dp[i - 1][j - 1]
           方案中所有的数都大于 1 的：dp[i - j][j]
           我们可以将 dp[i][j] 中所有方案中的所有数字都 - 1，此时剩下的方案中所有的数字就没有 1 了，
           而所有方案中的所有数字 - 1，相当于总数 - j，这个方案数量是和是 i - j
           并且恰好表示成 j 个数相加的方案，即 dp[i - j][j]。
        4. 初始化：dp[1][1] = 1，和是 1 的整数划分方案数为 1
        5. 结果：dp[n][1] + dp[n][2] + ... + dp[n][n]
         */
        var dp = new int[n + 1][n + 1];
        dp[1][1] = 1;
        for (int i = 2; i <= n; i++) { // 从和为 2 开始
            for (int j = 1; j <= i; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - j][j]) % mod;
            }
        }
        var sum = 0;
        for (int i = 1; i <= n; i++) sum = (sum + dp[n][i]) % mod;
        System.out.println(sum);
    }

}
