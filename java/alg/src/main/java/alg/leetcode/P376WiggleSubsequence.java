package alg.leetcode;

import java.util.Arrays;

/**
 * @link https://leetcode.cn/problems/wiggle-subsequence/
 * @author zhangxq
 * @since 2023/6/2
 */
public class P376WiggleSubsequence {
    
    public static void main(String[] args) {
        var solution = new P376WiggleSubsequence();
        var nums = new int[]{1,17,5,10,13,15,10,5,16,8};
        solution.wiggleMaxLength(nums);
    }
    
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length, idx = 0;
        // 去除相邻的重复元素
        for (int i = 0; i < n; i++) {
            int t = i;
            while (i + 1 < n && nums[i] == nums[i + 1]) i++;
            nums[idx++] = nums[t];
        }
        
        if (idx <= 2) return idx;
        int res = 2;
        for (int i = 1; i + 1 < idx; i++) {
            int a = nums[i - 1], b = nums[i], c = nums[i + 1];
            if (b > a && b > c || b < a && b < c) res++;
        }
        return res;
    }
}
