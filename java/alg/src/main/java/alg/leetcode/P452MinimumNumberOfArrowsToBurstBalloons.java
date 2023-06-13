package alg.leetcode;

import java.util.Arrays;

/**
 * @link https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/
 * @author zhangxq
 * @since 2023/6/13
 */
public class P452MinimumNumberOfArrowsToBurstBalloons {
    
    public static void main(String[] args) {
    
    }
    
    public int findMinArrowShots(int[][] points) {
        // 先对所有区间的右端点进行排序
        Arrays.sort(points, (o1, o2) -> {
            if (o1[1] > o2[1]) return 1;
            else return -1;
        });
        
        // r 记录当前已选区间的右端点
        int res = 1, r = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > r) {
                res++;
                r = points[i][1];
            }
        }
        return res;
    }
}
