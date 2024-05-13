package alg.acwing;

import java.util.Scanner;

/**
 * @link https://www.acwing.com/problem/content/899/
 * @author will
 * @since 2024/5/13
 */
public class P897 {
    
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        String s1 = sc.next(), s2 = sc.next();
        
        /*
        1. dp 子问题：要想求字符串 s1 和 s2 的最长公公子序列的长度就要求得
           s1 少一个字符和 s2 的最长公共子序列的长度和 s1 和 s2 少一个字符的最长公共子序列的长度
        2. dp 数组定义：dp[i][j] 存储的是字符串 s1[0, i) 和 s2[0, j) 的最长公共子序列的长度值
        3. dp 方程：
           s1[i - 1] = s2[j - 1]：dp[i][j] = dp[i - 1][j - 1] + 1
           s1[i - 1] != s2[j - 1]：dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
        4. 初始化 dp[0][0] = 0
        5. 结果 dp[n][m]
         */
        var dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        System.out.println(dp[n][m]);
    }
}
