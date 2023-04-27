package alg.leetcode;

import java.util.List;

/**
 * @author zhangxq
 * @link https://leetcode.cn/problems/pascals-triangle-ii/
 * @since 2023/4/27
 */
public class P119PascalsTriangleII {
    
    public static void main(String[] args) {
    
    }
    
    public List<Integer> getRow(int n) {
        Integer[][] f = new Integer[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            f[i][0] = f[i][i] = 1;
            for (int j = 1; j < i; j++) {
                f[i][j] = f[i - 1][j - 1] + f[i - 1][j];
            }
        }
        return List.of(f[n]);
    }
    
    /**
     * 滚动数组
     * * 将数组大小设置为 2
     * * 将数组访问的下标全都加上 & 1
     */
    public List<Integer> getRow2(int n) {
        Integer[][] f = new Integer[2][n + 1];
        for (int i = 0; i <= n; i++) {
            f[i & 1][0] = f[i & 1][i] = 1;
            for (int j = 1; j < i; j++) {
                f[i & 1][j] = f[i - 1 & 1][j - 1] + f[i - 1 & 1][j];
            }
        }
        return List.of(f[n & 1]);
    }
}
