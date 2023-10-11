package alg.leetcode;

import java.util.Arrays;

/**
 * @link https://leetcode.cn/problems/valid-triangle-number/
 * @author zhangxq
 * @since 2023/10/11
 */
public class P611ValidTriangleNumber {
    
    public static void main(String[] args) {
    
    }
    
    /**
     * 任意两边之和大于第三条边，就可以构成三角形
     * 满足 b + c > a
     */
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i - 1, k = 0; j > 0 && k < j; j--) {
                while (k < j && nums[k] <= nums[i] - nums[j]) k++;
                res += j - k;
            }
        }
        return res;
    }
}
