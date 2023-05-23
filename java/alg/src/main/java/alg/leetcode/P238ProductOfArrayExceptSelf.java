package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/product-of-array-except-self/
 * @author zhangxq
 * @since 2023/5/23
 */
public class P238ProductOfArrayExceptSelf {
    
    public static void main(String[] args) {
    
    }
    
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int t = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            t *= nums[i + 1];
            res[i] *= t;
        }
        return res;
    }
}
