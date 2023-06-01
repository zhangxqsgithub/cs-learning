package alg.leetcode;

import java.util.TreeSet;

/**
 * @link https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/
 * 矩阵区域不超过 K 的最大数值和
 */
public class P363MaxSumOfRectangleNoLargerThanK {
    
    public static void main(String[] args) {
        var set = new TreeSet<Integer>();
        set.add(1);
        set.add(2);
        // set.add(3);
        set.add(4);
        set.add(5);
        // System.out.println(set.floor(3));
        // System.out.println(set.ceiling(3));
        
        var solution = new P363MaxSumOfRectangleNoLargerThanK();
        int[][] matrix = {{2, 2, -1}};
        int res = solution.maxSumSubmatrix(matrix, 3);
        System.out.println(res);
    }
    
    int[][] s;
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        s = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                s[i][j] = matrix[i - 1][j - 1] + s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1];
        
        int res = Integer.MIN_VALUE;
        for (int x1 = 1; x1 <= m; x1++) {
            for (int x2 = x1; x2 <= m; x2++) {
                var set = new TreeSet<Integer>();
                set.add(0);
                for (int y2 = 1; y2 <= n; y2++) {
                    int cur = get(x2, y2, x1, 1);
                    Integer v = set.ceiling(cur - k);
                    if (v != null) res = Math.max(res, cur - v);
                    set.add(cur);
                }
            }
        }
        return res;
    }
    public int get(int x2, int y2, int x1, int y1) {
        return s[x2][y2] - s[x1 - 1][y2] - s[x2][y1 - 1] + s[x1 - 1] [y1 - 1];
    }
}
