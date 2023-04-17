package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/
 * @author zhangxq
 * @since 2023/4/17
 */
public class P80RemoveDuplicatesFromSortedArrayII {
    
    public static void main(String[] args) {
        P80RemoveDuplicatesFromSortedArrayII s1 = new P80RemoveDuplicatesFromSortedArrayII();
        
        int[] nums1 = {1, 1, 1, 2, 2, 3, 3, 4};
        int res1 = s1.removeDuplicates(nums1);
        System.out.println(res1);
    }
    
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) return nums.length;
        int k = 1;
        for (int i = 2; i < nums.length; i++) {
            // 如果当前数不等于 nums[k] 且不等于 nums[k−1]
            if(nums[i] != nums[k - 1]) {
                nums[++k] = nums[i];
            }
        }
        return k + 1;
    }
    
}
