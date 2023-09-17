package alg.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * @link https://leetcode.cn/problems/next-greater-element-i/
 * @author zhangxq
 * @since 2023/9/14
 */
public class P496NextGreaterElementI {
    
    public static void main(String[] args) {
        var solution = new P496NextGreaterElementI();
        var res1 = solution.nextGreaterValue(new int[]{1,3,4,2});
        System.out.println(Arrays.toString(res1));
    }
    
    /**
     * 数组 nums1 和 nums2 中的数字不重复。
     * 第一步：求解 nums2 中所有数字的下一个更大数字是多少
     * 第二步：根据 nums1[i] 这个数字所在 nums2 数组中的位置，即可得到下一个更大数字
     *
     * 设数组 nums，求数组 nums 的下一个更大数字的数组 q，n 为 nums 数组的长度。
     * nums[n - 1] 的下一个更大数字是 -1；
     * nums[n - 2] 的下一个更大数字是，若 nums[n - 2] < nums[n - 1] 的话，结果为 nums[n - 1] 否则结果为 -1；
     * 任给一个 0 <= i < n，求 nums[i] 的下一个更大数字是多少。分三种情况讨论
     * 1. nums[i] < nums[i + 1]  ：nums[i + 1] 是 nums[i] 的下一个更大数字
     * 2. nums[i] == nums[i + 1] ：下一个更大数字与 nums[i + 1] 相同
     * 3. nums[i] > nums[i + 1]  ：nums[i] 的下一个更大数字不是 nums[i + 1]，
     * 可能是 nums[i + 1] 的下一个更大数字，或者再下一个。（单调递增）
     * 这里存在单调性，即设 nums[i] 的下一个更大的数字是 f(i)，f(i) > nums[i] 成立。
     * 若 nums[i] > nums[i + 1]，nums[i] < f(i + 1)：nums[i] 的下一个更大数是 f(i + 1)，f(i + 1) 这个数字会存在于单调的数据结构中
     * 若 nums[i] > nums[i + 1]，nums[i] >= f(i + 1)：继续向后求解，即求 f(f(i + 1))
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 缓存 nums2 数字所对应的下标
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums2.length; i++) map.put(nums2[i], i);
        
        // 单调栈
        var stk = new Stack<Integer>();
        // q[i] 保存数字 nums2[i] 的下一个更大元素的值。
        var q = new int[nums2.length];
        for (int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];
            while (!stk.isEmpty() && stk.peek() <= num) stk.pop();
            if (stk.isEmpty()) q[i] = -1;
            else q[i] = stk.peek();
            stk.push(num);
        }
        
        var res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) res[i] = q[map.get(nums1[i])];
        return res;
    }
    
    
    /**
     * 下一个更大数数组
     */
    public int[] nextGreaterValue(int[] nums) {
        var n = nums.length;
        var q = new int[n];
        var stk = new Stack<Integer>();
        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];
            while (!stk.isEmpty() && stk.peek() <= num) stk.pop();
            if (stk.isEmpty()) q[i] = -1;
            else q[i] = stk.peek();
            stk.push(num);
        }
        return q;
    }
}
