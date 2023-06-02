package alg.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @link https://leetcode.cn/problems/largest-divisible-subset/
 * @author zhangxq
 * @since 2023/6/2
 */
public class P368LargestDivisibleSubset {
    
    public static void main(String[] args) {
    
    }
    
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        int k = 0; // 表示最大值的尾节点的位置
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[k] < dp[i]) k = i;
        }
        List<Integer> res = new ArrayList<>();
        while (true) {
            res.add(nums[k]);
            if (dp[k] == 1) break;
            for (int i = 0; i < k; i++) {
                if (nums[k] % nums[i] == 0 && dp[k] == dp[i] + 1) {
                    k = i;
                    break;
                }
            }
        }
        return res;
    }
}
