package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/add-digits/
 * @author zhangxq
 * @since 2023/5/24
 */
public class P258AddDigits {
    
    public static void main(String[] args) {
    
    }
    
    public int addDigits(int num) {
        if (num == 0) return 0;
        int res = num % 9;
        return res == 0 ? 9 : res;
    }
}
