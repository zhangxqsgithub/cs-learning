package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/rotate-function/
 * @author zhangxq
 * @since 2023/6/7
 */
public class P396RotateFunction {
    
    public static void main(String[] args) {
    
    }
    
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        long sum = 0, cur = 0;
        for (var x : nums) sum += x;
        for (int i = 0; i < n; i++) cur += (long) i * nums[i];
        long res = cur;
        for (int i = n - 1; i >= 0; i--) {
            cur += sum - (long) n * nums[i];
            res = Math.max(res, cur);
        }
        return (int) res;
    }
}
