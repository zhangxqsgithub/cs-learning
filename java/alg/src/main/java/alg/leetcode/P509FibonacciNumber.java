package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/fibonacci-number/
 * @author zhangxq
 * @since 2023/9/17
 */
public class P509FibonacciNumber {
    
    public static void main(String[] args) {
        var solution = new P509FibonacciNumber();
        System.out.println(solution.fib2(0));
        System.out.println(solution.fib2(1));
        System.out.println(solution.fib2(2));
        System.out.println(solution.fib2(3));
        System.out.println(solution.fib2(4));
        System.out.println(solution.fib2(5));
        System.out.println(solution.fib2(6));
        System.out.println(solution.fib2(7));
        System.out.println(solution.fib2(8));
    }
    
    public int fib(int n) {
        if (n == 0) return 0;
        if (1 <= n && n < 3) return 1;
        
        var dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    
    public int fib2(int n) {
        if (n == 0) return 0;
        if (1 <= n && n < 3) return 1;
        
        // 设 dp[i - 1] = a; dp[i - 2] = b;
        // c = dp[i - 1] + dp[i - 2] = a + b
        int a = 0, b = 1, c = a + b;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
