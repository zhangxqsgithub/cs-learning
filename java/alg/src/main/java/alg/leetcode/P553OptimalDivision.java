package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/optimal-division/
 * @author zhangxq
 * @since 2023/9/28
 */
public class P553OptimalDivision {
    
    public static void main(String[] args) {
    
    }
    
    public String optimalDivision(int[] nums) {
        int n = nums.length;
        if (n == 0) return "";
        if (n == 1) return String.valueOf(nums[0]);
        if (n == 2) return nums[0] + "/" + nums[1];
        
        var sb = new StringBuilder();
        sb.append(nums[0]).append("/(");
        for (int i = 1; i + 1 < nums.length; i++) {
            sb.append(nums[i]).append("/");
        }
        sb.append(nums[n - 1]).append(")");
        return sb.toString();
    }
}
