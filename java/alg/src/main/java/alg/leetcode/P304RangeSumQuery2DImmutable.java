package alg.leetcode;

/**
 * @author zhangxq
 * @link https://leetcode.cn/problems/range-sum-query-2d-immutable/
 * @since 2023/5/29
 */
public class P304RangeSumQuery2DImmutable {
    
    public static void main(String[] args) {
        int[][] matrix1 = new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}};
        NumMatrix nm = new NumMatrix(matrix1);
        nm.sumRegion(2, 1, 4, 3);
    }
    
    static
    class NumMatrix {
        int[][] s;
        public NumMatrix(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) return;
            int n = matrix.length, m = matrix[0].length;
            s = new int[n + 1][m + 1];
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= m; j++)
                    s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + matrix[i - 1][j - 1];
        }
        
        public int sumRegion(int x1, int y1, int x2, int y2) {
            x1++; y1++; x2++; y2++;
            return s[x2][y2] - s[x1 - 1][y2] - s[x2][y1 - 1] + s[x1 - 1][y1 - 1];
        }
    }
}
