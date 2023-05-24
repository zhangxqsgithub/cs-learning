package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/search-a-2d-matrix-ii/
 * @author zhangxq
 * @since 2023/5/24
 */
public class P240SearchA2DMatrixII {
    
    public static void main(String[] args) {
    
    }
    
    /**
     * 从矩阵的右上角开始找
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int n = matrix.length, m = matrix[0].length;
        int i = 0, j = m - 1;
        while (i < n && j >= 0) {
            int t = matrix[i][j];
            if (t == target) return true;
            else if (t > target) j--;
            else i++;
        }
        return false;
    }
}
