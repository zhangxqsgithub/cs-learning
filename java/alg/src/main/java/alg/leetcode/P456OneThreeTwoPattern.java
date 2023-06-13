package alg.leetcode;

import java.util.Stack;

/**
 * @link https://leetcode.cn/problems/132-pattern/
 * @author zhangxq
 * @since 2023/6/13
 */
public class P456OneThreeTwoPattern {
    
    public static void main(String[] args) {
    
    }
    
    // 单调栈
    public boolean find132pattern(int[] nums) {
        int right = Integer.MIN_VALUE;
        var stk = new Stack<Integer>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < right) return true;
            while (!stk.isEmpty() && stk.peek() < nums[i]) {
                right = Math.max(right, stk.pop());
            }
            stk.push(nums[i]);
        }
        return false;
    }
}
