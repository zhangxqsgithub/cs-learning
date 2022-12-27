package alg.leetcode;

import java.util.Arrays;

/**
 * 移除元素
 *
 * @author zhangxq
 * @link https://leetcode.cn/problems/remove-element/
 * @since 2022/12/26
 */
public class P27RemoveElement {
    
    public static void main(String[] args) {
        var nums1 = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        var val1 = 2;
        var solution = new P27RemoveElement();
        var res1 = solution.removeElement(nums1, val1);
        System.out.println(res1);
        System.out.println(Arrays.toString(nums1));
    }
    
    // 双指针
    // l 指向开始， r 指向数组的结尾，每次 l + 1 判断是否与 val 相等，若不相等则跳过
    // 若相等则与 r 交换后 r - 1
    public int removeElement(int[] nums, int val) {
        int l = 0, r = nums.length;
        
        while (l < r) {
            if (nums[l] == val) {
                nums[l] = nums[--r];
            }
            else {
                l++;
            }
        }
        
        return l;
    }
}
