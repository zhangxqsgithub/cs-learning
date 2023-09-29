package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/array-nesting/
 * @author zhangxq
 * @since 2023/9/29
 */
public class P565ArrayNesting {
    
    public static void main(String[] args) {
    
    }
    
    public int arrayNesting(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != -1) {
                int j = i, s = 0;
                while (nums[j] != -1) {
                    s++;
                    int next = nums[j];
                    nums[j] = -1;
                    j = next;
                }
                res = Math.max(res, s);
            }
        }
        return res;
    }
}
