package alg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @link https://leetcode.cn/problems/number-of-boomerangs/
 * @author zhangxq
 * @since 2023/6/12
 */
public class P447NumberOfBoomerangs {
    
    public static void main(String[] args) {
    
    }
    
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            var cnt = new HashMap<Integer, Integer>();
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    int dx = points[i][0] - points[j][0];
                    int dy = points[i][1] - points[j][1];
                    int dist = dx * dx + dy * dy;
                    cnt.put(dist, cnt.getOrDefault(dist, 0) + 1);
                }
            }
            for (var e : cnt.entrySet()) {
                res += e.getValue() * (e.getValue() - 1);
            }
        }
        return res;
    }
}
