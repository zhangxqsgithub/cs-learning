package alg.acwing;

import java.util.Scanner;

/**
 * @link https://www.acwing.com/problem/content/description/898/
 * @author will
 * @since 2024/5/13
 */
public class P896 {
    
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var n = sc.nextInt();
        var a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        
        var len = 0;
        var dp = new int[n];
        dp[0] = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            // 二分查找
            int l = 0, r = len;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (dp[mid] < a[i]) l = mid;
                else r = mid - 1;
            }
            len = Math.max(len, r + 1);
            dp[r + 1] = a[i];
        }
        System.out.println(len);
    }
}
