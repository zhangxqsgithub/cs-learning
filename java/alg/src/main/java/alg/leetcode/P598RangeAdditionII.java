package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/range-addition-ii/
 * @author zhangxq
 * @since 2023/9/30
 */
public class P598RangeAdditionII {
    
    public static void main(String[] args) {
    
    }
    
    public int maxCount(int m, int n, int[][] ops) {
        int x = m, y = n;
        for (var p : ops) {
            x = Math.min(x, p[0]);
            y = Math.min(y, p[1]);
        }
        return x * y;
    }
}
