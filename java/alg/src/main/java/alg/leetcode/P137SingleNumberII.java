package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/single-number-ii/
 * @author zhangxq
 * @since 2023/5/3
 */
public class P137SingleNumberII {
    
    public static void main(String[] args) {
    
    }
    
    /**
     * 状态机 DFA
     */
    public int singleNumber(int[] nums) {
        int one = 0, two = 0;
        for (int x : nums) {
            one = (one ^ x) & ~two;
            two = (two ^ x) & ~one;
        }
        return one;
    }
}
