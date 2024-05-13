package alg.acwing;

import java.util.Scanner;

/**
 * @link https://www.acwing.com/problem/content/901/
 * @author will
 * @since 2024/5/13
 */
public class P899 {
    
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        var s = new String[n];
        for (int i = 0; i < n; i++) s[i] = sc.next();
        
        for (int i = 0; i < m; i++) {
            var s2 = sc.next();
            var upper = sc.nextInt();
            var res = 0;
            // 每次计算最短编辑距离
            for (int j = 0; j < n; j++) {
                var med = minEditDistance(s[j], s2);
                if (med <= upper) res ++;
            }
            System.out.println(res);
        }
    }
    
    public static int minEditDistance(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        var dp = new int[n + 1][m + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) dp[i][0] = i;
        for (int j = 1; j <= m; j++) dp[0][j] = j;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
            }
        }
        return dp[n][m];
    }
}
