package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/arranging-coins/
 * @author zhangxq
 * @since 2023/6/12
 */
public class P441ArrangingCoins {
    
    public static void main(String[] args) {
    
    }
    
    public int arrangeCoins(int n) {
        return (int) ((-1 + Math.sqrt(1 + 8.0 * n)) / 2);
    }
}
