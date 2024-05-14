package alg.acwing;

/**
 * 整数划分
 *
 * @link https://www.acwing.com/problem/content/902/
 * @author will
 * @since 2024/5/14
 */
public class P900 {
    
    public static void main(String[] args) {
        
        /*
        1. dp 子问题：
        2. dp 数组定义：dp[i][j] 表示和是 i 并且恰好表示成 j 个数相加的方案数量
        3. dp 方程 动态转移方程：
        4. 初始化：dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]
           方案中最小值是 1 的：dp[i - 1][j - 1]
           方案中大于 1 的：dp[i - 1][j]
           我们可以将 dp[i][j] 中所有方案中的所有数字都 - 1，此时剩下的方案中所有的数字就没有 1 了，
           而所有方案中的所有数字 - 1，这个方案数量是和是 i - 1 并且恰好表示称 j 个数相加的方案，
           即 dp[i - 1]。
        5. 结果：
         */
    }

}
