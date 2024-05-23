package alg.acwing;

import java.util.Scanner;

/**
 * 登山
 *
 * @link https://www.acwing.com/problem/content/description/1016/
 * @author will
 * @since 2024/5/23
 */
public class P1014 {
    
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var n = sc.nextInt();
        var arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        
        var lis = lis(arr);
        var lcs = lcs(arr);
        var res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, lis[i] + lcs[i] - 1);
        }
        System.out.println(res);
    }
    
    private static int[] lis(int[] arr) {
        int n = arr.length;
        var dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp;
    }
    
    private static int[] lcs(int[] arr) {
        int n = arr.length;
        var dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp;
    }
    
}
