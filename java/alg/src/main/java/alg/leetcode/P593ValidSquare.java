package alg.leetcode;

import java.util.Arrays;

/**
 * @author zhangxq
 * @link https://leetcode.cn/problems/valid-square/
 * @since 2023/9/30
 */
public class P593ValidSquare {
    
    public static void main(String[] args) {
    
    }
    
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        var p = new int[][]{p1, p2, p3, p4};
        // 保存 4 条边的边长和 2 条对角线都边长
        var d = new int[6];
        for (int i = 0, idx = 0; i < 4; i++)
            for (int j = i + 1; j < 4; j++)
                d[idx++] = dist(p[i], p[j]);
        Arrays.sort(d);
        if (d[0] == 0) return false;
        return d[0] == d[1] && d[0] == d[2] && d[0] == d[3] && d[4] == d[5];
    }
    
    private int dist(int[] a, int[] b) {
        int dx = a[0] - b[0], dy = a[1] - b[1];
        return dx * dx + dy * dy;
    }
}
