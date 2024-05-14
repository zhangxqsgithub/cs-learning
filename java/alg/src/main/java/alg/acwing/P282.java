package alg.acwing;

import java.util.Scanner;

/**
 * 石子合并
 * 区间 DP 问题
 *
 * 第一次合并的时候有 n - 1 种方式
 * 第二次合并的时候有 n - 2 种方式
 * 合并的方式有 (n-1)! 种
 *
 * @link https://www.acwing.com/problem/content/284/
 * @author will
 * @since 2024/5/14
 */
public class P282 {
    
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var n = sc.nextInt();
        var s = new int[n];
        for (int i = 0; i < n; i++) s[i] = sc.nextInt();
        
        // 前缀和数组
        var sum = new int[n + 1];
        for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + s[i - 1];
        /*
        1. dp 子问题
        2. dp 数组定义：dp[i][j] 表示所有将 [i - 1, j - 1] 区间内石子合并成一堆的方案中最小代价值
        3. dp 方程：
           dp[i][j] 是 [i - 1, j - 1] 区间内方案中最小代价，在这个区间内取得所有合并方案的代价和，并取最小代价值即可。
           所有合并方案是
           [i - 1, i - 1] + [i    , j - 1]
           [i - 1, i    ] + [i + 1, j - 1]
           ...
           [i - 1, j - 2] + [j - 1, j - 1]
           可以设 k = [i - 1, j - 2]
           我们可以从 1 开始枚举，所以 k 的取值可以是 k = [i, j)
           之后将所有方案合并的最小代价 + sum[j] - sum[i - 1]
           dp[i][j] = min(dp[i][j], dp[i][k] + dp[k + 1][j] + sum[j] - sum[i - 1])
        4. 初始化：
        5. 结果：dp[1][n] 表示第 1 堆石子到第 n 堆石子合并起来的最小代价，
           即所有石子合并起来的最小代价
         */
        var dp = new int[n + 1][n + 1];
        // 区间 DP 一般从长度开始枚举
        // 从 2 开始枚举是因为 1 堆石子合并到一起的代价为 0 所以无需计算
        for (int len = 2; len <= n; len++) {
            // 枚举区间左端点
            for (int i = 1; i + len - 1 <= n; i++) {
                // 枚举区间右端点
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + sum[j] - sum[i - 1]);
                }
            }
        }
        System.out.println(dp[1][n]);
        
        /*
        区间 DP 要先枚举长度
        n = 5
            len = 2
            i = [1, 2, 3, 4] j = [2, 3, 4, 5] 表示i~j的区间可以是 1~2,2～3,3~4,4~5，每个区间长度为2
            len = 3
            i = [1, 2, 3] j = [3, 4, 5] 表示i~j的区间可以是1~3,2～4,3~5，每个区间长度为3
            len = 4
            i = [1, 2] j = [4, 5] 表示i~j的区间可以是1~4,2~5，每个区间长度为4
            len = 5
            i = [1] j = [5] 表示i~j的区间可以是1~5，每个区间长度为5
         */
    }
}
