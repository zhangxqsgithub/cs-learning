package alg.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @link https://leetcode.cn/problems/minimum-time-difference/
 * @author zhangxq
 * @since 2023/9/26
 */
public class P539MinimumTimeDifference {
    
    public static void main(String[] args) {
    
    }
    
    public int findMinDifference(List<String> timePoints) {
        int res = Integer.MAX_VALUE;
        // 将时间按照分钟数存下来
        var q = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            var s = timePoints.get(i);
            var arr = s.split(":");
            q[i] = Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
        }
        Arrays.sort(q);
        for (int i = 1; i < q.length; i++) res = Math.min(res, q[i] - q[i - 1]);
        res = Math.min(res, 1440 - q[q.length - 1] + q[0]);
        return res;
    }
}
