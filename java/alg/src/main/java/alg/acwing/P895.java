package alg.acwing;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @link https://www.acwing.com/problem/content/897/
 * @author will
 * @since 2024/5/12
 */
public class P895 {
    
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var n = sc.nextInt();
        var s = new int[n];
        for (int i = 0; i < n; i++)
            s[i] = sc.nextInt();
        
        /*
        dp 分析
        1. dp 子问题
           某个单调递增的子序列长度最大值是，前面所有数字中比当前值小的单调递增子序列长度的最大值 + 1，
           若前面没有数字比当前值小，则为 1。
        2. dp 数组定义
           dp 数组保存以某个数结尾的单调递增子序列的长度最大值数组，
           dp[i] 表示数组 s[0, i] 中以 s[i] 数字结尾的单调递增子序列的长度最大值。
        3. dp 方程
           dp[i] = ( s[j] < s[i] && max(dp[0 ... j]), j=0...i-1 ) + 1
        4. 初始化 dp[i] = 1, i=0...n-1 因为每个元素自己构成一个上升序列
        5. 结果 max(dp[i]), i=0...n-1
         */
        var dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++)
            for (int j = 0; j < i; j++)
                if (s[j] < s[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
        
        var res = 0;
        for (int i = 0; i < n; i++)
            res = Math.max(res, dp[i]);
        System.out.println(res);
    }
    
}
