package alg.leetcode;

/**
 * 矩阵置零
 *
 * @author zhangxq
 * @link https://leetcode.cn/problems/set-matrix-zeroes/
 * @since 2023/1/14
 */
public class P73SetMatrixZeroes {
    
    public static void main(String[] args) {
    
    }
    
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        int m = matrix.length, n = matrix[0].length;
        // 记录行和列是否需要设置为 0
        int r0 = 1, c0 = 1;
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                r0 = 0;
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                c0 = 0;
                break;
            }
        }
        
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        // j 列置 0
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m; i++) matrix[i][j] = 0;
            }
        }
        // i 列置 0
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < n; j++) matrix[i][j] = 0;
            }
        }
        // 第 0 行置 0
        if (r0 == 0) {
            for (int j = 0; j < n; j++) matrix[0][j] = 0;
        }
        // 第 0 列置 0
        if (c0 == 0) {
            for (int i = 0; i < m; i++) matrix[i][0] = 0;
        }
    }
}
