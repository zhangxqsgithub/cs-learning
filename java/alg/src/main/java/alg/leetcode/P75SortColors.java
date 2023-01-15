package alg.leetcode;

import java.util.Arrays;

/**
 * 颜色分类
 *
 * @author zhangxq
 * @link https://leetcode.cn/problems/sort-colors/
 * @since 2023/1/15
 */
public class P75SortColors {
    
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        P75SortColors solution = new P75SortColors();
        solution.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
    
    public void sortColors(int[] nums) {
        int r = -1, w = 0, b = nums.length;
        while (w < b) {
            if (nums[w] == 0) {
                swap(nums, w, ++r);
                w++;
            }
            else if (nums[w] == 1) {
                w++;
            }
            else if (nums[w] == 2) {
                swap(nums, w, --b);
            }
        }
    }
    
    private void swap(int[] nums, int i1, int i2) {
        int t = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = t;
    }
    
}
