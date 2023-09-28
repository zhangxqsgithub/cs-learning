package alg.leetcode;

import java.util.HashMap;
import java.util.List;

/**
 * @link https://leetcode.cn/problems/brick-wall/
 * @author zhangxq
 * @since 2023/9/28
 */
public class P554BrickWall {
    
    public static void main(String[] args) {
    
    }
    
    public int leastBricks(List<List<Integer>> wall) {
        // 保存每一个横坐标上有多少个缝隙（缝隙最多的那跳线）
        var map = new HashMap<Integer, Integer>();
        for (var line : wall) {
            for (int i = 0, s = 0; i + 1 < line.size(); i++) {
                s += line.get(i);
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        int max = 0;
        // 找到穿过缝隙的最大值
        for (var e : map.entrySet()) max = Math.max(max, e.getValue());
        return wall.size() - max;
    }
}
