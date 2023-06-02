package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/guess-number-higher-or-lower/
 * @author zhangxq
 * @since 2023/6/2
 */
public class P374GuessNumberHigherOrLower {
    
    public static void main(String[] args) {
    
    }
    
    public int guessNumber(int n) {
        int l = 1, r = n;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (guess(mid) <= 0) r = mid;
            else l = mid + 1;
        }
        return r;
    }
    
    public int guessNumber2(int n) {
        int l = 1, r = n;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (guess(mid) == -1) r = mid - 1;
            else if (guess(mid) == 1) l = mid + 1;
            else if (guess(mid) == 0) return mid;
        }
        return 0;
    }
    
    // 这是 leetCode 给的方法
    public int guess(int x) { return 0; }
}


