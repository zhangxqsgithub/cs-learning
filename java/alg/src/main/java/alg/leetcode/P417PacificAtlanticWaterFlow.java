package alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @link https://leetcode.cn/problems/pacific-atlantic-water-flow/
 * @author zhangxq
 * @since 2023/6/9
 */
public class P417PacificAtlanticWaterFlow {
    
    public static void main(String[] args) {
    
    }
    
    int m; int n;
    int[][] heights;
    int[][] st;
    int[] dx = {-1, 0, 1, 0}; int[] dy = {0, -1, 0, 1};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        var res = new ArrayList<List<Integer>>();
        if (heights.length == 0 || heights[0].length == 0) return res;
        m = heights.length; n = heights[0].length;
        this.heights = heights;
        st = new int[m][n];
        // 枚举太平洋
        for (int i = 0; i < m; i++) dfs(i, 0, 1);
        for (int i = 0; i < n; i++) dfs(0, i, 1);
        // 枚举大西洋
        for (int i = 0; i < m; i++) dfs(i, n - 1, 2);
        for (int i = 0; i < n; i++) dfs(m - 1, i, 2);
        
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (st[i][j] == 3)
                    res.add(List.of(i, j));
        return res;
    }
    public void dfs(int x, int y, int t) {
        if ((st[x][y] & t) != 0) return;
        st[x][y] |= t;
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i], b = y + dy[i];
            if (0<=a&&a<m&&0<=b&&b<n&&heights[x][y]<=heights[a][b]) {
                dfs(a, b, t);
            }
        }
    }
}
