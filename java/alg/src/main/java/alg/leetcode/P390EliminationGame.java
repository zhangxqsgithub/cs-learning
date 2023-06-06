package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/elimination-game/
 * @author zhangxq
 * @since 2023/6/6
 */
public class P390EliminationGame {
    
    public static void main(String[] args) {
    
    }
    
    // 约瑟夫问题
    public int lastRemaining(int n) {
        if (n == 1) return 1;
        return 2 * (n / 2 + 1 - lastRemaining(n / 2));
    }
}
