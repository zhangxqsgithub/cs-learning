package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/minimum-moves-to-equal-array-elements/
 * @author zhangxq
 * @since 2023/6/13
 */
public class P453MinimumMovesToEqualArrayElements {
    
    public static void main(String[] args) {
    
    }
    
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (var x : nums) min = Math.min(min, x);
        int res = 0;
        for (var x : nums) res += x - min;
        return res;
    }
}
