package alg;

/**
 * 动态规划五步法：
 * 1. 确定 DP 子问题
 * 2. DP 数组定义
 * 3. DP 方程
 * 4. 初始化 DP 数组
 * 5. 结果
 *
 * @author zhangxq
 * @since 2023/9/17
 */
public class DP {
    
    public static void main(String[] args) {
        var solution = new DP();
        var res1 = solution.fib3(10);
        System.out.println(res1);
    }
    
    public int fib1(int n) {
        if (n <= 2) return 1;
        return fib1(n - 1) + fib1(n - 2);
    }
    
    int[] cache = new int[100_000];
    public int fib2(int n) {
        if (n <= 2) return 1;
        int res = fib2(n - 1) + fib2(n - 2);
        // 缓存当前步的值
        cache[n] = res;
        return res;
    }
    
    public int fib3(int n) {
        // 1. dp 数组定义
        int[] dp = new int[n + 1];
        // 2. 初始化
        dp[1] = 1;
        dp[2] = 1;
        // 3. 状态转移方程
        for (int i = 3; i <= n; i++) {
            int res = dp[i - 1] + dp[i - 2];
            dp[i] = res;
        }
        return dp[n];
    }
}
