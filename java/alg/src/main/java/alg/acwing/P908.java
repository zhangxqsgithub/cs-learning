package alg.acwing;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 最大不相交区间数量
 *
 * @link https://www.acwing.com/problem/content/910/
 * @author will
 * @since 2024/5/19
 */
public class P908 {
    
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var n = sc.nextInt();
        var intervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int p = Integer.MIN_VALUE, res = 0;
        for (int i = 0; i < n; i++) {
            int l = intervals[i][0], r = intervals[i][1];
            if (!(l <= p && p <= r)) {
                p = intervals[i][1];
                res++;
            }
        }
        System.out.println(res);
    }
}
