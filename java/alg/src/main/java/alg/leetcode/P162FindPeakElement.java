package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/find-peak-element/
 * @author zhangxq
 * @since 2023/5/7
 */
public class P162FindPeakElement {
    
    public static void main(String[] args) {
    
    }
    
    public int findPeakElement(int[] nums) {
        var l = 0; var r = nums.length - 1;
        while (l < r) {
            var mid = l + r >> 1;
            if (nums[mid] < nums[mid + 1]) l = mid + 1;
            else r = mid;
        }
        return r;
    }
}
