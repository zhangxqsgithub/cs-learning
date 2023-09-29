package alg.leetcode;

import java.util.Arrays;

/**
 * @link https://leetcode.cn/problems/erect-the-fence/
 * @author zhangxq
 * @since 2023/9/29
 */
public class P587ErectTheFence {
    
    public static void main(String[] args) {
    
    }
    
    public int[][] outerTrees(int[][] trees) {
        Arrays.sort(trees, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        int n = trees.length;
        // 表示树是否被使用
        var used = new boolean[n];
        // 表示凸包
        var hull = new int[n + 2];
        int top = 0;
        for (int i = 0; i < n; i++) {
            while (top >= 2 && area(trees[hull[top - 1]], trees[hull[top]], trees[i]) > 0)
                used[hull[top --]] = false;
            hull[++top] = i;
            used[i] = true;
        }
        used[0] = false;
        for (int i = n - 1; i >= 0; i--) {
            if (used[i]) continue;
            while (top >= 2 && area(trees[hull[top - 1]], trees[hull[top]], trees[i]) > 0)
                top--;
            hull[++top] = i;
        }
        top--;
        // 记录答案
        var res = new int[top][2];
        for (int i = 1; i <= top; i++) {
            res[i - 1][0] = trees[hull[i]][0];
            res[i - 1][1] = trees[hull[i]][1];
        }
        return res;
    }
    private int area(int[] a, int[] b, int[] c) {
        return cross(b[0] - a[0], b[1] - a[1], c[0] - a[0], c[1] - a[1]);
    }
    // 求差积
    private int cross(int x1, int y1, int x2, int y2) {
        return x1 * y2 - x2 * y1;
    }
}
