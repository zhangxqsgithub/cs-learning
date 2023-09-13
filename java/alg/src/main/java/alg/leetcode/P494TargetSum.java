package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/target-sum/
 * @author zhangxq
 * @since 2023/9/13
 */
public class P494TargetSum {
    
    public static void main(String[] args) {
        var solution = new P494TargetSum();
        var res1 = solution.findTargetSumWays(new int[]{1,1,1,1,1}, 5);
        System.out.println(res1);
    }
    
    int target, cnt = 0;
    public int findTargetSumWays(int[] nums, int target) {
        this.target = target;
        dfs(nums, 0, 0);
        return cnt;
    }
    private void dfs(int[] nums, int idx, int sum) {
        if (idx == nums.length) {
            if (target == sum) cnt++;
            return;
        }
        int num = nums[idx];
        dfs(nums, idx + 1, sum - num);
        dfs(nums, idx + 1, sum + num);
    }
}
