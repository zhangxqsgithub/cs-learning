package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/shortest-unsorted-continuous-subarray/
 * @author zhangxq
 * @since 2023/9/29
 */
public class P581ShortestUnsortedContinuousSubarray {
    
    public static void main(String[] args) {
    
    }
    
    public int findUnsortedSubarray(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l + 1 < nums.length && nums[l + 1] >= nums[l]) l++;
        if (l == r) return 0;
        while (r - 1 >= 0 && nums[r - 1] <= nums[r]) r--;
        for (int i = l + 1; i < nums.length; i++)
            while (l >= 0 && nums[l] > nums[i])
                l--;
        for (int i = r - 1; i >= 0; i--)
            while (r < nums.length && nums[r] < nums[i])
                r++;
        return r - l - 1;
    }
    
    public int findUnsortedSubarray2(int[] nums) {
        // 在左右两边找到已经排好序的两段，且左段的最大值小于右边所有元素，右段的最小值大于左边的所有元素
        // 左段为 [0, l] 右段为[r, nums.length - 1]
        int n = nums.length, l = 0, r = n - 1;
        // 扫描一遍找到左边保持升序的最后一个点的位置（从左往右看）
        while (l + 1 < n && nums[l + 1] >= nums[l]) l++;
        if (l == r) return 0;
        // 扫描一遍找到右边保持降序的最后一个点的位置（从右往左看）
        while (r > 0 && nums[r - 1] <= nums[r]) r--;
        // 接下来我们从 l + 1 的位置向右扫描，如果遇到有比 nums[l] 小的元素，说明 l 不在正确位置上，那么 l--
        for (int i = l + 1; i < n; i++)
            while (l >= 0 && nums[l] > nums[i])
                l--;
        // 同样的，我们从 r - 1 的位置向左扫描，如果遇到有比 nums[r] 大的元素，说明 r 不在正确的位置上，r++
        for (int i = r - 1; i >= 0; i--)
            while (r < n && nums[r] < nums[i])
                r++;
        // 最后 (l, r) 之间的元素就是需要重新排序的元素
        return r - l - 1;
    }
    
}
