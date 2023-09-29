package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/out-of-boundary-paths/
 * @author zhangxq
 * @since 2023/9/29
 */
public class P576OutOfBoundaryPaths {
    
    public static void main(String[] args) {
    
    }
    
    public int findPaths(int m, int n, int maxMove, int x, int y) {
        if (maxMove == 0) return 0;
        long MOD = (long) 1e9 + 7;
        var dp = new long[m][n][maxMove + 1];
        for (int i = 0; i < n; i++) {
            dp[0][i][1]++;
            dp[m - 1][i][1]++;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0][1]++;
            dp[i][n - 1][1]++;
        }
        var dxdy = new int[][]{{0, -1, 0, 1}, {-1, 0, 1, 0}};
        for (int k = 1; k <= maxMove; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int u = 0; u < 4; u++) {
                        int a = i + dxdy[0][u], b = j + dxdy[1][u];
                        if (a >= 0 && a < m && b >= 0 && b < n) {
                            dp[i][j][k] = (dp[i][j][k] + dp[a][b][k - 1]) % MOD;
                        }
                    }
                }
            }
        }
        
        long res = 0;
        for (int k = 1; k <= maxMove; k++) res = (res + dp[x][y][k]) % MOD;
        return (int) res;
    }
}
