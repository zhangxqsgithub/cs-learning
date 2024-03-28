package alg.acwing_course.base;

import java.util.Arrays;

/**
 * 前缀和 与 差分
 * 前缀和 与 差分是一对逆运算。
 * @author zhangxq
 * @since 2023/6/20
 */
public class C105PrefixSum {
    
    public static void main(String[] args) {
        var sum = new Sum();
        var arr1 = new int[]{1, 2, 3};
        sum.sum(arr1);
        
        var matrix1 = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        var sumMatrix = new SumMatrix();
        sumMatrix.sumMatrix(matrix1);
        
        // 差分
        var sub = new Sub();
        var arr3 = new int[]{1, 3, 6};
        sub.sub(arr3);
        
        var subMatrix = new SubMatrix();
        var matrix2 = new int[][] {
                {1, 3, 6},
                {5, 12, 21},
                {12, 27, 45}
        };
        subMatrix.sub(matrix2);
    }
    
    // 一维前缀和
    static class Sum {
        int[] s; // s[i] 中保存的是 arr[0, i) 的和
        public void sum(int[] arr) {
            int n = arr.length;
            s = new int[n + 1]; // 为了很好的处理边界问题，需要多申请一个长度
            for (int i = 1; i <= n; i++) {
                s[i] = s[i - 1] + arr[i - 1];
            }
            System.out.println(Arrays.toString(s));
        }
        // 求 arr 数组中 [l, r] 区间内的和
        public int get(int l, int r) {
            // + 1 便于理解
            l++; r++;
            return s[r] - s[l - 1];
        }
    }
    
    /**
     * 二维前缀和
     */
    static class SumMatrix {
        int[][] s;
        public void sumMatrix(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            s = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++)
                for (int j = 1; j <= n; j++)
                    s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + matrix[i - 1][j - 1];
            System.out.println(Arrays.deepToString(s));
        }
        // 求 matrix[x1, x2][y1, y2] 的和
        public int get(int x1, int y1, int x2, int y2) {
            x1++; y1++; x2++; y2++;
            return s[x2][y2] - s[x1 - 1][y2] - s[x2][y1 - 1] + s[x1 - 1][y1 - 1];
        }
    }
    
    /**
     * 差分
     * 前缀和的逆运算（给定一个前缀和数组，求原数组）
     * 给定一个数组 A 其中的元素为 a1, a2, a3, ..., an，求数组 B 其中的元素为 b1, b2, b3, ..., bn，
     * 使得 ai = b1 + b2 + b3 + ... + bi 成立。
     * 即 A 是 B 的前缀和数组。
     *
     * s[i] = s[i - 1] + arr[i - 1]
     * arr[i] = s[i] - s[i - 1]
     * 差分这里下标从 0 开始，则无需 i - 1
     */
    static class Sub {
        int[] arr;
        public void sub(int[] s) {
            int n = s.length;
            arr = new int[n];
            arr[0] = s[0];
            for (int i = 1; i < n; i++) arr[i] = s[i] - s[i - 1];
            System.out.println(Arrays.toString(arr));
        }
    }
    
    /**
     * 差分矩阵
     */
    static class SubMatrix {
        int[][] matrix;
        public void sub(int[][] s) {
            int m = s.length, n = s[0].length;
            matrix = new int[m][n];
            matrix[0][0] = s[0][0];
            for (int i = 1; i < n; i++) matrix[0][i] = s[0][i] - s[0][i - 1];
            for (int i = 1; i < m; i++) matrix[i][0] = s[i][0] - s[i - 1][0];
            for (int i = 1; i < m; i++)
                for (int j = 1; j < n; j++)
                    matrix[i][j] = s[i][j] - s[i - 1][j] - s[i][j - 1] + s[i - 1][j - 1];
            System.out.println(Arrays.deepToString(matrix));
        }
    }
}
