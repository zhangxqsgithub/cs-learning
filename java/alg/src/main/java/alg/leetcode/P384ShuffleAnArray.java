package alg.leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * @link https://leetcode.cn/problems/shuffle-an-array/
 * @author zhangxq
 * @since 2023/6/5
 */
public class P384ShuffleAnArray {
    
    public static void main(String[] args) {
    
    }
    
    static
    class Solution {
        int[] nums;
        public Solution(int[] nums) {
            this.nums = nums;
        }
        public int[] reset() {
            return nums;
        }
        public int[] shuffle() {
            var r = new Random();
            var n = nums.length;
            var res = Arrays.copyOf(nums, n);
            for (int i = 0; i < n; i++) {
                int rand = i + r.nextInt(Integer.MAX_VALUE) % (n - i);
                int t = res[i];
                res[i] = res[rand];
                res[rand] = t;
            }
            return res;
        }
    }
}
