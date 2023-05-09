package alg.leetcode;

import java.util.Arrays;

/**
 * @link https://leetcode.cn/problems/kth-largest-element-in-an-array/
 * @author zhangxq
 * @since 2023/5/9
 */
public class P215KthLargestElementInAnArray {
    
    public static void main(String[] args) {
        P215KthLargestElementInAnArray solution = new P215KthLargestElementInAnArray();
        
        var nums = new int[]{3, 2, 1, 5, 6, 4};
        var res = solution.findKthLargest(nums, 2);
        System.out.println(res);
    }
    
    // 快速选择算法
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1, nums.length - k);
        return nums[nums.length - k];
    }
    
    public void quickSort(int[] nums, int l, int r, int k) {
        if (l >= r) return;
        
        int lt = l, gt = r + 1, pivot = nums[l], i = l + 1;
        while (i < gt) {
            if (nums[i] < pivot) swap(nums, i++, ++lt);
            else if (nums[i] > pivot) swap(nums, i, --gt);
            else i++;
        }
        swap(nums, l, lt);
        if (k < lt) quickSort(nums, l, lt - 1, k);
        else if (k >= gt) quickSort(nums, gt, r, k);
    }
    
    public void swap(int[] nums, int x, int y) {
        var t = nums[x];
        nums[x] = nums[y];
        nums[y] = t;
    }
}
