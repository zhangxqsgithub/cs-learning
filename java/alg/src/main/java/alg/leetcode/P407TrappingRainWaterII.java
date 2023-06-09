package alg.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @link https://leetcode.cn/problems/trapping-rain-water-ii/
 * @author zhangxq
 * @since 2023/6/8
 */
public class P407TrappingRainWaterII {
    
    public static void main(String[] args) {
    
    }
    
    public int trapRainWater(int[][] map) {
        if (map.length == 0 || map[0].length == 0) return 0;
        int m = map.length, n = map[0].length;
        // 小根堆
        var heap = new PriorityQueue<Cell>(Comparator.comparingInt(o -> o.h));
        // 判重数组
        var v = new boolean[m][n];
        // 将四个边界更新
        for (int i = 0; i < m; i++) {
            v[i][0] = v[i][n - 1] = true;
            heap.add(Cell.of(map[i][0], i, 0));
            heap.add(Cell.of(map[i][n - 1], i, n - 1));
        }
        for (int i = 1; i + 1 < n; i++) {
            v[0][i] = v[m - 1][i] = true;
            heap.add(Cell.of(map[0][i], 0, i));
            heap.add(Cell.of(map[m - 1][i], m - 1, i));
        }
        int res = 0;
        int[] dx = {-1, 0, 1, 0}; int[] dy = {0, -1, 0, 1};
        while (!heap.isEmpty()) {
            var t = heap.poll();
            res += t.h - map[t.x][t.y]; // 答案加上最终高度和真实高度的差
            
            for (int i = 0; i < 4; i++) {
                int x = t.x + dx[i], y = t.y + dy[i];
                if (0<=x&&x<m&&0<=y&&y<n&&!v[x][y]) {
                    heap.add(Cell.of(Math.max(map[x][y], t.h), x, y));
                    v[x][y] = true;
                }
            }
        }
        return res;
    }
    static class Cell {
        int h; int x; int y;
        public static Cell of(int h, int x, int y) {
            var res = new Cell();
            res.h = h; res.x = x; res.y = y;
            return res;
        }
    }
}
