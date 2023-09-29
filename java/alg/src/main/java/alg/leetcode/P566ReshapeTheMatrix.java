package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/reshape-the-matrix/
 * @author zhangxq
 * @since 2023/9/29
 */
public class P566ReshapeTheMatrix {
    
    public static void main(String[] args) {
    
    }
    
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat.length == 0 || mat[0].length == 0) return mat;
        int m = mat.length, n = mat[0].length;
        if (m * n != r * c) return mat;
        
        var res = new int[r][c];
        int x = 0, y = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0 ; j < n; j++) {
                res[x][y] = mat[i][j];
                y++;
                if (y >= c) {
                    y = 0;
                    x++;
                }
            }
        }
        return res;
    }
}
