package alg.leetcode;

import java.util.Stack;

/**
 * @link https://leetcode.cn/problems/next-greater-element-ii/
 * @author zhangxq
 * @since 2023/9/15
 */
public class P503NextGreaterElementII {
    
    public static void main(String[] args) {
    
    }
    
    /**
     * 利用「破环成链技巧」，即将原数组复制一份放在后面即可。
     */
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        var copy = new int[n * 2];
        System.arraycopy(nums, 0, copy, 0, n);
        System.arraycopy(nums, 0, copy, n, n);
        
        var res = new int[n];
        var stk = new Stack<Integer>();
        for (int i = copy.length - 1; i >= 0; i--) {
            int num = copy[i];
            while (!stk.isEmpty() && stk.peek() <= num) stk.pop();
            if (i < n) {
                if (stk.isEmpty()) res[i] = -1;
                else res[i] = stk.peek();
            }
            stk.push(num);
        }
        return res;
    }
}
