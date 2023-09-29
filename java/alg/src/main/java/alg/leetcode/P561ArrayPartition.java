package alg.leetcode;

import java.util.Arrays;

/**
 * @link https://leetcode.cn/problems/array-partition/
 * @author zhangxq
 * @since 2023/9/29
 */
public class P561ArrayPartition {
    
    public static void main(String[] args) {
    
    }
    
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) sum += nums[i];
        return sum;
    }
}
