package alg.leetcode;

import java.util.Arrays;

/**
 * @link https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii/
 * @author zhangxq
 * @since 2023/6/15
 */
public class P462MinimumMovesToEqualArrayElementsII {
    
    public static void main(String[] args) {
    
    }
    
    // 找数组的中位数
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < n; i++)
            res += Math.abs(nums[i] - nums[n / 2]);
        return res;
    }
    
}
