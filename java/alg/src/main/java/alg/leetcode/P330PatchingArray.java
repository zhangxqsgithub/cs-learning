package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/patching-array/
 * @author zhangxq
 * @since 2023/5/31
 */
public class P330PatchingArray {
    
    public static void main(String[] args) {
    
    }
    
    public int minPatches(int[] nums, int n) {
        long x = 1;
        int i = 0, res = 0;
        while (x <= n) {
            if (i < nums.length && nums[i] <= x) x += nums[i++];
            else {
                x += x;
                res++;
            }
        }
        return res;
    }
}
