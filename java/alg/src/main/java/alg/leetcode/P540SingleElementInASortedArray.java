package alg.leetcode;

import java.util.Arrays;

/**
 * @link https://leetcode.cn/problems/single-element-in-a-sorted-array/
 * @author zhangxq
 * @since 2023/9/27
 */
public class P540SingleElementInASortedArray {
    
    public static void main(String[] args) {
    
    }
    
    /**
     * 两两分组、使用二分查找
     */
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            // 通过异或操作，对所有下标进行两两分组
            if (nums[mid] == nums[mid ^ 1]) l = mid + 1;
            else r = mid;
        }
        return nums[l];
    }
}
