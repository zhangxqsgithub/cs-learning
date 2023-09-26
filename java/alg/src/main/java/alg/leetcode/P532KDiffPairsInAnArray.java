package alg.leetcode;

import java.util.Arrays;

/**
 * @link https://leetcode.cn/problems/k-diff-pairs-in-an-array/
 * @author zhangxq
 * @since 2023/9/26
 */
public class P532KDiffPairsInAnArray {
    
    public static void main(String[] args) {
    
    }
    
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            // 对于 i 指针跳过相同的数
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) i++;
            // i 前面找到一个 j 使得 nums[i] - nums[j] <= k
            while (j < i && nums[i] - nums[j] > k) j++;
            if (j < i && nums[i] - nums[j] == k) res++;
        }
        return res;
    }
}
