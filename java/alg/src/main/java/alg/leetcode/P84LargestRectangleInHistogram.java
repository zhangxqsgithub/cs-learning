package alg.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @link https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 * 柱状图中最大的矩形
 */
public class P84LargestRectangleInHistogram {
    
    public static void main(String[] args) {
    
    }
    
    /**
     * 单调栈法
     * 维护一个单调递增的栈，例如
     * [2, 1, 5, 6, 2, 3]
     * 栈中元素 1, 5, 6 是单调递增的，依次向前计算最大值即可。
     * 6 ～ 5 的最大值为 10
     * 6 ～ 1 的的最大值为 3
     * 最大值的计算为 ( cur - left - 1 ) * min(cur, left)
     */
    public static int largestRectangleArea(int[] h) {
        int n = h.length;
        int[] l = new int[n], r = new int[n];
        
        // 单调栈
        Deque<Integer> s = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // 只要有前一个数比后面一个数大，就可以把它删掉
            while (!s.isEmpty() && h[s.peek()] >= h[i]) s.pop();
            l[i] = (s.isEmpty() ? -1 : s.peek());
            s.push(i);
        }
        s.clear(); // 清空栈
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && h[s.peek()] >= h[i]) s.pop();
            r[i] = (s.isEmpty() ? n : s.peek());
            s.push(i);
        }
        
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, (r[i] - l[i] - 1) * h[i]);
        }
        return res;
    }
    
}
