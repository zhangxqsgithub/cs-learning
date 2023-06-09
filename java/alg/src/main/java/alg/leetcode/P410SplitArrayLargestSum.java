package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/split-array-largest-sum/
 * @author zhangxq
 * @since 2023/6/9
 */
public class P410SplitArrayLargestSum {
    
    public static void main(String[] args) {
    
    }
    
    public int splitArray(int[] nums, int k) {
        int l = 0, r = Integer.MAX_VALUE;
        while (l < r) {
            int mid = l + (r - l) / 2;
            // 判断 mid 是否成立
            if (check(nums, k, mid)) r = mid;
            else l = mid + 1;
        }
        return r;
    }
    // 贪心
    public boolean check(int[] nums, int k, int mid) {
        int sum = 0; // 表示当前这段的和
        int cnt = 0; // 段数
        for (var x : nums) {
            // 一定无解
            if (x > mid) return false;
            if (sum + x > mid) { // x 需要放到新的一段
                cnt++;
                sum = x;
            }
            else sum += x;
        }
        if (sum != 0) cnt++;
        return cnt <= k;
    }
}
