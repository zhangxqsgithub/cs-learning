package alg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @link https://leetcode.cn/problems/max-points-on-a-line/
 * @author zhangxq
 * @since 2023/5/7
 */
public class P149MaxPointsOnALine {
    
    public static void main(String[] args) {
    
    }
    
    public int maxPoints(int[][] points) {
        var res = 0;
        for (int[] p : points) {
            var cnt = new HashMap<Double, Integer>();
            var ss = 0; var vs = 0;
            for (int[] q: points) {
                if (p == q) ss++;              // 和中心点重叠
                else if (p[0] == q[0]) vs++;   // 说明在垂线上
                else {
                    double k = (double) (q[1] - p[1]) / (q[0] - p[0]);
                    cnt.put(k, cnt.getOrDefault(k, 0) + 1);
                }
            }
            var c = vs;
            for (Map.Entry<Double, Integer> entry : cnt.entrySet())
                c = Math.max(c, entry.getValue());
            res = Math.max(res, c + ss);
        }
        return res;
    }
}
