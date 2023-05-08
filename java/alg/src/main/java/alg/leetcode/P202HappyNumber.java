package alg.leetcode;

/**
 * @author zhangxq
 * @link https://leetcode.cn/problems/happy-number/
 * @since 2023/5/8
 */
public class P202HappyNumber {
    
    public static void main(String[] args) {
    
    }
    
    public boolean isHappy(int n) {
        int fast = get(n), slow = n;
        while (fast != slow) {
            fast = get(get(fast));
            slow = get(slow);
        }
        return fast == 1;
    }
    
    public int get(int x) {
        var res = 0;
        while (x != 0) {
            res += (x % 10) * (x % 10);
            x /= 10;
        }
        return res;
    }
}
