package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/single-number/
 * @author zhangxq
 * @since 2023/5/3
 */
public class P136SingleNumber {
    
    public int singleNumber(int[] nums) {
        var res = 0;
        for (var i : nums) res ^= i;
        return res;
    }
    
}
