package alg.leetcode;

/**
 * @author zhangxq
 * @link https://leetcode.cn/problems/search-in-rotated-sorted-array-ii/
 * @since 2023/4/17
 */
public class P81SearchInRotatedSortedArrayII {
    
    public static void main(String[] args) {
    
    }
    
    public boolean search(int[] nums, int target) {
        for (int num : nums)
            if (target == num)
                return true;
        return false;
    }
}
