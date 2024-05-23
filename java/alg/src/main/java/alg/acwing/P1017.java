package alg.acwing;

import java.util.Scanner;

/**
 * 怪盗基德的滑翔翼
 * @link https://www.acwing.com/problem/content/1019/
 * @author will
 * @since 2024/5/23
 */
public class P1017 {
    
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var q = sc.nextInt();
        while (q-- > 0) {
            var n = sc.nextInt();
            var buildings = new int[n];
            for (int i = 0; i < n; i++) buildings[i] = sc.nextInt();
            var lis = lis(buildings);
            var lcs = lcs(buildings);
            System.out.println(Math.max(lis, lcs));
        }
    }
    
    /**
     * 最长上升子序列
     */
    public static int lis(int[] arr) {
        var n = arr.length;
        var dp = new int[n];
        var res = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    
    /**
     * 最长下降子序列
     */
    public static int lcs(int[] arr) {
        var n = arr.length;
        var dp = new int[n];
        var res = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
