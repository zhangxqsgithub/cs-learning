package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/increasing-triplet-subsequence/
 * @author zhangxq
 * @since 2023/5/31
 */
public class P334IncreasingTripletSubsequence {
    
    public static void main(String[] args) {
        P334IncreasingTripletSubsequence solution = new P334IncreasingTripletSubsequence();
        
        int[] nums = new int[]{20,100,10,12,5,13};
        solution.increasingTriplet(nums);
    }
    
    public boolean increasingTriplet(int[] nums) {
        if (nums.length == 0) return false;
        int n = nums.length;
        int[] dp = new int[n]; // 递增数组
        dp[0] = nums[0];
        int cur = 1; // 当前处理的记录最长子序列的长度
        int res = 1; // 最长递增子序列的大小
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            int j = res - 1; // j 从最长子序列的最后开始遍历
            for (; j >= 0; j--) if (dp[j] < num) break;
            dp[j + 1] = num;
            cur = j + 2;
            res = Math.max(res, cur);
        }
        return res >= 3;
    }
}
