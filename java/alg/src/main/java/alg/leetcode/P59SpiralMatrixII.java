package alg.leetcode;

/**
 * 螺旋矩阵 II
 *
 * @author zhangxq
 * @link https://leetcode.cn/problems/spiral-matrix-ii/
 * @since 2023/1/11
 */
public class P59SpiralMatrixII {
    
    public int[][] generateMatrix(int n) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int c = 1;
        int[][] res = new int[n][n];
        // 标记是否访问过
        boolean[][] v = new boolean[n][n];
        for (int i = 0, x = 0, y = 0, d = 0; i < n*n; i++) {
            res[x][y] = c++;
            v[x][y] = true;
            // 尝试往前走一步，若失败则改变方向并往前走
            int a = x + dx[d], b = y + dy[d];
            // 改变方向
            if (a < 0 || a >= n || b < 0 || b >= n || v[a][b]) {
                d = (d + 1) % 4;
                a = x + dx[d];
                b = y + dy[d];
            }
            x = a;
            y = b;
        }
        return res;
    }
}
