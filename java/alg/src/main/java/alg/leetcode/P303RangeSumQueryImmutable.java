package alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @link https://leetcode.cn/problems/range-sum-query-immutable/
 * @author zhangxq
 * @since 2023/5/28
 */
public class P303RangeSumQueryImmutable {
    
    public static void main(String[] args) {
    
    }
    
    /**
     * 前缀和技巧
     */
    static
    class NumArray {
        int[] s;
        public NumArray(int[] nums) {
            s = new int[nums.length + 1];
            for (int i = 1; i <= nums.length; i++) {
                s[i] = s[i - 1] + nums[i - 1];
            }
        }
        
        public int sumRange(int i, int j) {
            i++; j++;
            return s[j] - s[i - 1];
        }
    }
}
