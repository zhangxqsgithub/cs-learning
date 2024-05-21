package alg.acwing;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 区间覆盖
 *
 * @link https://www.acwing.com/problem/content/909/
 * @author will
 * @since 2024/5/19
 */
public class P907 {
    
    /**
     * 1. 将所有区间按照左端点从小到打排序
     * 2. 依次枚举每个区间，在所有能覆盖 start 区间中选择一个右端点最大的，选择完成之后
     *    将 start 更新成右端点最大值，直到 start 值 >= end 值就算是覆盖掉了所有区间。
     */
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int start = sc.nextInt(), end = sc.nextInt();
        var n = sc.nextInt();
        var intervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int res = 0;
        boolean success = false;
        for (int i = 0; i < n; i++) {
            int j = i, maxR = Integer.MIN_VALUE;
            while (j < n && intervals[j][0] <= start) {
                maxR = Math.max(maxR, intervals[j][1]);
                j++;
            }
            // 无解
            if (maxR < start) break;
            res++;
            // 已经覆盖了所有区间
            if (maxR >= end) {
                success = true;
                break;
            }
            start = maxR;
            i = j - 1;
        }
        if (!success) res = -1;
        System.out.println(res);
    }
}
