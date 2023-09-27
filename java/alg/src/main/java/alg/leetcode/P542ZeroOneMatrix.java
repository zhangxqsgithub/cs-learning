package alg.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @link https://leetcode.cn/problems/01-matrix/
 * @author zhangxq
 * @since 2023/9/27
 */
public class P542ZeroOneMatrix {
    
    public static void main(String[] args) {
    
    }
    
    /**
     * 多原 BFS（多个原点的 BFS 问题）
     */
    public int[][] updateMatrix(int[][] mat) {
        if (mat.length == 0 || mat[0].length == 0) return mat;
        int m = mat.length, n = mat[0].length;
        // 距离数组
        var dist = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(dist[i], -1);
        // 队列
        Queue<int[]> que = new LinkedList<>();
        // 将所有的 0 插入到队列里
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0;
                    que.offer(new int[]{i, j});
                }
            }
        }
        var dxdy = new int[][]{{0, -1, 0, 1}, {-1, 0, 1, 0}};
        while (!que.isEmpty()) {
            var t = que.poll();
            
            for (int i = 0; i < 4; i++) {
                int x = t[0] + dxdy[0][i], y = t[1] + dxdy[1][i];
                if (x >= 0 && x < m && y >= 0 && y < n && dist[x][y] == -1) {
                    dist[x][y] = dist[t[0]][t[1]] + 1;
                    que.offer(new int[]{x, y});
                }
            }
        }
        return dist;
    }
}
