package alg.leetcode;

import java.util.Arrays;

/**
 * @author zhangxq
 * @link https://leetcode.cn/problems/wiggle-sort-ii/
 * @since 2023/5/30
 */
public class P324WiggleSortII {
    
    public static void main(String[] args) {
    
    }
    
    public void wiggleSort(int[] nums) {
        if (nums.length == 1) return;
        int mid = quickGet(nums, 0, nums.length - 1, (nums.length - 1) / 2);
        int l = 0;
        int r = nums.length - 1;
        for (int i = 0; i <= r; ) {
            if (nums[i] < mid) swap(nums, i++, l++);
            else if (nums[i] > mid) swap(nums, i, r--);
            else i++;
        }
        int m = (nums.length - 1) / 2;
        int[] a = Arrays.copyOfRange(nums, 0, m + 1);
        int[] b = Arrays.copyOfRange(nums, m + 1, nums.length);
        for (int i = 0; i < a.length; i++) {
            nums[i * 2] = a[a.length - 1 - i];
        }
        for (int i = 0; i < b.length; i++) {
            nums[i * 2 + 1] = b[b.length - 1 - i];
        }
    }
    
    public int quickGet(int[] nums, int l, int r, int k) {
        if (l == r) return nums[k];
        int pivot = nums[l];
        int i = l - 1;
        int j = r + 1;
        while (i < j) {
            do i++; while (pivot > nums[i]);
            do j--; while (pivot < nums[j]);
            if (i < j) swap(nums, i, j);
        }
        if (k <= j) return quickGet(nums, l, j, k);
        else return quickGet(nums, j + 1, r, k);
    }
    
    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
