package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array-ii/
 * @author zhangxq
 * @since 2023/5/7
 */
public class P154FindMinimumInRotatedSortedArrayII {
    
    public static void main(String[] args) {
    
    }
    
    public int findMin(int[] nums) {
        var l = 0; var r = nums.length - 1;
        while (l < r && nums[r] == nums[0]) r--;
        // 若成立，则说明数组有序
        if (nums[l] <= nums[r]) return nums[0];
        while (l < r) {
            var mid = l + r >> 1;
            if (nums[mid] < nums[0]) r = mid;
            else l = mid + 1;
        }
        return nums[r];
    }
}
