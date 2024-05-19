package alg.acwing;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 区间选点
 *
 * @link https://www.acwing.com/problem/content/907/
 * @author will
 * @since 2024/5/19
 */
public class P905 {
    
    /**
     * 1. 将每个区间按照右端点从小到大排序
     * 2. 从前往后依次枚举每个区间，如果当前区间已包含点，则直接 pass
     *    否则选择前区间的右端点。
     */
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var n = sc.nextInt();
        var intervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int res = 0;
        int p = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int l = intervals[i][0], r = intervals[i][1];
            if (l <= p && p <= r) continue;
            else {
                p = intervals[i][1];
                res++;
            }
        }
        System.out.println(res);
    }
}
