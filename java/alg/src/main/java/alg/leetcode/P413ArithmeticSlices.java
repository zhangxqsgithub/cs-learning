package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/arithmetic-slices/
 * @author zhangxq
 * @since 2023/6/9
 */
public class P413ArithmeticSlices {
    
    public static void main(String[] args) {
    
    }
    
    /**
     * 1. 将数组变成差分数组
     * 2. 在差分数组中找出连续相等的段即可
     */
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        for (int i = n - 1; i > 0; i--) nums[i] -= nums[i - 1];
        int res = 0;
        for (int i = 1; i < n; i++) {
            int j = i;
            while (j < n && nums[i] == nums[j]) j++;
            int k = j - i;
            res += k * (k - 1) / 2;
            i = j - 1;
        }
        return res;
    }
}
