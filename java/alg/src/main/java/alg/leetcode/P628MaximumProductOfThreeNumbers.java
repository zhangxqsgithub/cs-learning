package alg.leetcode;

import java.util.Arrays;

/**
 * @link https://leetcode.cn/problems/maximum-product-of-three-numbers/
 * @author zhangxq
 * @since 2024/2/24
 */
public class P628MaximumProductOfThreeNumbers {
    
    public static void main(String[] args) {
    
    }
    
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        var n = nums.length;
        return Math.max(
                nums[n - 1] * nums[n - 2] * nums[n - 3],  // 三个正数
                nums[0] * nums[1] * nums[n - 1]           // 两个大负数，一个正数
        );
    }
}
