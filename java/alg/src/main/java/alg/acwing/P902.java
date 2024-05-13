package alg.acwing;

import java.util.Scanner;

/**
 * @link https://www.acwing.com/problem/content/description/904/
 * @author will
 * @since 2024/5/13
 */
public class P902 {
    
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s1 = sc.next();
        int m = sc.nextInt();
        String s2 = sc.next();
        
        /*
        1. dp 子问题：要想知道字符串 s1 和 s2 的最短编辑距离，就要知道
           字符串 s1 少一个字符和 s2 的最短编辑距离
           字符串 s1 和 s2 少一个字符的最短编辑距离
           字符串 s1 少一个字符和 s2 少一个字符的最短编辑距离
        2. dp 数组定义：dp[i][j] 保存 s1[0, i) 和 s2[0, j) 的最短编辑距离值
        3. dp 方程：
           s1[i - 1] == s2[j - 1]：dp[i][j] = dp[i - 1][j - 1] // 无需删除、插入、替换操作
           s1[i - 1] != s2[j - 1]：dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1 // 需要一次删除、插入或替换操作
           替换操作： dp[i - 1][j - 1] 表示 s1[0, i-1) 和 s2[0, j-1) 字符串最短编辑距离，
           若要求 s1[0, i) 和 s2[0, j) 的最短编辑距离，则需要做一步替换，
           即将 s1[i - 1] = s2[j - 1] 或 s2[j - 1] = s1[i - 1]
           删除操作： 对字符串 s1 做一步删除操作，删除字符 s1[i - 1] 之后的最短编辑距离值是 dp[i - 1][j]
                    对字符串 s2 做一步删除操作，删除字符 s2[j - 1] 之后的最段编辑距离值是 dp[i][j - 1]
           插入操作：同删除操作
        4. 初始化 dp[0][0]=0, dp[i][0]=i, dp[0][j]=j
           空字符串到字符串 s 的最短编辑距离是 s.length();
        5. 结果 dp[n][m]
         */
        var dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) dp[i][0] = i;
        for (int j = 1; j <= m; j++) dp[0][j] = j;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
            }
        }
        System.out.println(dp[n][m]);
    }
}
