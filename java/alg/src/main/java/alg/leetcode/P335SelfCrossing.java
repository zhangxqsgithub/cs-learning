package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/self-crossing/
 * @author zhangxq
 * @since 2023/5/31
 */
public class P335SelfCrossing {
    
    public static void main(String[] args) {
    
    }
    
    // 只会在连续 4、5、6 步以内，出现交点的情况
    public boolean isSelfCrossing(int[] d) {
        int n = d.length;
        if (n <= 3) return false;
        for (int i = 3; i < n; i++) {
            if (d[i-1]<=d[i-3]&&d[i-2]<=d[i]) return true;
            if (i>=4&&d[i-3]==d[i-1]&&d[i]+d[i-4]>=d[i-2]) return true;
            if (i>=5&&d[i-3]>=d[i-1]&&d[i-1]+d[i-5]>=d[i-3]&&d[i-2]>=d[i-4]&&d[i-4]+d[i]>=d[i-2])
                return true;
        }
        return false;
    }
}
