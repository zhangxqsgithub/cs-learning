package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/teemo-attacking/
 * @author zhangxq
 * @since 2023/9/14
 */
public class P495TeemoAttacking {
    
    public static void main(String[] args) {
    
    }
    
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = 0;
        for (int i = 1; i < timeSeries.length; i++) {
            res += Math.min(timeSeries[i] - timeSeries[i - 1], duration);
        }
        if (timeSeries.length > 0) res += duration;
        return res;
    }
}
