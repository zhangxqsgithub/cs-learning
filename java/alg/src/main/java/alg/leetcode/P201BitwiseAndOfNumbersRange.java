package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/bitwise-and-of-numbers-range/
 * @author zhangxq
 * @since 2023/5/8
 */
public class P201BitwiseAndOfNumbersRange {
    
    public static void main(String[] args) {
    
    }
    
    public int rangeBitwiseAnd(int m, int n) {
        var res = 0;
        for (var i = 30; i >= 0; i--) {
            if ((m >> i & 1) != (n >> i & 1)) break;
            if ((m >> i & 1) == 1) res += 1 << i;
        }
        return res;
    }
}
