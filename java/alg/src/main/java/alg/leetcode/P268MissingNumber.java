package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/missing-number/
 * @author zhangxq
 * @since 2023/5/25
 */
public class P268MissingNumber {
    
    public static void main(String[] args) {
    
    }
    
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int res = n * (n + 1) / 2;
        for (var x : nums) res -= x;
        return res;
    }
}
