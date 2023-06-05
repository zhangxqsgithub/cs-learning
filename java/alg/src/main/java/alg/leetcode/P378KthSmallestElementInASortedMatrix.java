package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/kth-smallest-element-in-a-sorted-matrix/
 * @author zhangxq
 * @since 2023/6/5
 */
public class P378KthSmallestElementInASortedMatrix {
    
    public static void main(String[] args) {
        var solution = new P378KthSmallestElementInASortedMatrix();
        var matrix = new int[][]{{-5,-4}, {-5,-4}};
        int res = solution.kthSmallest(matrix, 2);
        System.out.println(res);
    }
    
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int l = matrix[0][0], r = matrix[m - 1][n - 1];
        while (l < r) {
            int mid = l + (r - l) / 2;
            int j = n - 1, cnt = 0;
            for (int i = 0; i < m; i++) {
                while (j >= 0 && matrix[i][j] > mid) j--;
                cnt += j + 1;
            }
            if (cnt < k) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
