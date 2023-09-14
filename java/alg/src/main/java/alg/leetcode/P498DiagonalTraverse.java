package alg.leetcode;

import java.util.Arrays;

/**
 * @author zhangxq
 * @link https://leetcode.cn/problems/diagonal-traverse/
 * @since 2023/9/14
 */
public class P498DiagonalTraverse {
    
    public static void main(String[] args) {
        var solution = new P498DiagonalTraverse();
        var res1 = solution.findDiagonalOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        });
        System.out.println(Arrays.toString(res1));
    }
    
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat.length == 0 || mat[0].length == 0) return new int[0];
        
        int m = mat.length, n = mat[0].length;
        var res = new int[m * n];
        int idx = 0;
        // 遍历每一条对角线
        for (int i = 0; i < m + n - 1; i++) {
            if (i % 2 == 0) { // 从下往上的对角线
                for (int j = Math.min(i, m - 1); j >= Math.max(0, 1 - n + i); j--) {
                    res[idx++] = mat[j][i - j];
                }
            }
            else { // 从上往下的对角线
                for (int j = Math.max(0, 1 - n + i); j <= Math.min(i, m - 1); j++) {
                    res[idx++] = mat[j][i - j];
                }
            }
        }
        return res;
    }
    
}
