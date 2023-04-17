package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/
 * @author zhangxq
 * @since 2023/4/17
 */
public class P80RemoveDuplicatesFromSortedArrayII {
    
    public static void main(String[] args) {
        P80RemoveDuplicatesFromSortedArrayII s1 = new P80RemoveDuplicatesFromSortedArrayII();
        
        int[] nums1 = {1, 1, 2, 2, 3, 3, 4};
        int res1 = s1.removeDuplicates(nums1);
        System.out.println(res1);
    }
    
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }
    
}
