package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/find-the-duplicate-number/
 * @author zhangxq
 * @since 2023/5/26
 */
public class P287FindTheDuplicateNumber {
    
    public static void main(String[] args) {
    
    }
    
    public int findDuplicate(int[] nums) {
        int a = 0, b = 0;
        while (true) {
            a = nums[a];
            b = nums[nums[b]];
            if (a == b) {
                a = 0;
                while (a != b) {
                    a = nums[a];
                    b = nums[b];
                }
                return a;
            }
        }
    }
}
