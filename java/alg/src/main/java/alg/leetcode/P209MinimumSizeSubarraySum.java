package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/minimum-size-subarray-sum/
 * @author zhangxq
 * @since 2023/5/8
 */
public class P209MinimumSizeSubarraySum {

    public static void main(String[] args) {

    }

    public int minSubArrayLen(int s, int[] nums) {
        var res = Integer.MAX_VALUE;
        for (int i = 0, j = 0, sum = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum - nums[j] >= s) sum -= nums[j++];
            if (sum >= s) res = Math.min(res, i - j + 1);
        }
        if (res == Integer.MAX_VALUE) res = 0;
        return res;
    }
}
