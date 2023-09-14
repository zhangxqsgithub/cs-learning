package alg.leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * @link https://leetcode.cn/problems/next-greater-element-i/
 * @author zhangxq
 * @since 2023/9/14
 */
public class P496NextGreaterElementI {
    
    public static void main(String[] args) {
    
    }
    
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 缓存 nums2 数字所对应的下标
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i <  nums2.length; i++) map.put(nums2[i], i);
        
        // 单调栈
        var stk = new Stack<Integer>();
        var q = new int[nums2.length];
        for (int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];
            while (!stk.isEmpty() && num >= stk.peek()) stk.pop();
            if (stk.isEmpty()) q[i] = -1;
            else q[i] = stk.peek();
            stk.push(num);
        }
        
        var res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) res[i] = q[map.get(nums1[i])];
        return res;
    }
}
