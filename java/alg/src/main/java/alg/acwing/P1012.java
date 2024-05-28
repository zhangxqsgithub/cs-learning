package alg.acwing;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 友好城市
 *
 * 如何确定好所有合法的建桥方案？
 * 所有合法的建桥方式 => 上升子序列；
 * 当自变量往右走时，因变量需要满足上升子序列的要求。
 * <p>
 * <img src="../../../../../docs/AcWing_p1012.png" alt="解释图片"></img>
 * </p>
 *
 *
 * @link https://www.acwing.com/problem/content/1014/
 * @author will
 * @since 2024/5/23
 */
public class P1012 {
    
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        var q = new Pair[n];
        for (int i = 0; i < n; i++) {
            q[i] = new Pair(sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(q, (a, b) -> Integer.compare(a.first, b.first));
        // 最长上升子序列的长度
        var res = 0;
        var dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (q[i].second > q[j].second) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        System.out.println(res);
    }
    static class Pair {
        int first;
        int second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
