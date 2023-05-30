package alg.leetcode;

import java.util.Arrays;

/**
 * @link https://leetcode.cn/problems/longest-increasing-path-in-a-matrix/
 * @author zhangxq
 * @since 2023/5/30
 */
public class P329LongestIncreasingPathInAMatrix {
    
    public static void main(String[] args) {
    
    }
    
    // DP 记忆化搜索
    int[][] matrix;
    int m; int n;
    int[][] f;
    int[][] d = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        this.matrix = matrix;
        m = matrix.length; n = matrix[0].length;
        f = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(f[i], -1);
        
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dp(i, j));
            }
        }
        return res;
    }
    public int dp(int x, int y) {
        var v = f[x][y];
        if (v != -1) return v;
        v = 1;
        for (int i = 0; i < 4; i++) {
            int a = x + d[i][0];
            int b = y + d[i][1];
            if (a >= 0 && a < m && b >= 0 && b < n && matrix[x][y] < matrix[a][b]) {
                v = Math.max(v, dp(a, b) + 1);
                f[x][y] = v;
            }
        }
        return v;
    }
    
    // 暴搜做法
    // int[][] matrix;
    // int m; int n;
    public int longestIncreasingPath2(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        m = matrix.length; n = matrix[0].length;
        this.matrix = matrix;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int steps = dfs(i, j, -1, 0);
                res = Math.max(res, steps);
            }
        }
        return res;
    }
    
    public int dfs(int i, int j, int from, int step) {
        if (m <= i || i < 0 || n <= j || j < 0 || from >= matrix[i][j]) {
            return step;
        }
        int top = dfs(i - 1, j, matrix[i][j], step + 1);
        int left = dfs(i, j - 1, matrix[i][j], step + 1);
        int down = dfs(i + 1, j, matrix[i][j], step + 1);
        int right = dfs(i, j + 1, matrix[i][j], step + 1);
        return Math.max(Math.max(Math.max(top, left), down), right);
    }
}
