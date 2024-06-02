package alg.acwing;

import java.util.Scanner;

/**
 * 最大上升子序列和
 *
 * @link https://www.acwing.com/problem/content/description/1018/
 * @author will
 * @since 2024/5/28
 */
public class P1016 {
    
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var n = sc.nextInt();
        var a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        
        // 最长上升子序列
        var res = 0;
        var dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = a[i];
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + a[i]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        System.out.println(res);
    }
}
