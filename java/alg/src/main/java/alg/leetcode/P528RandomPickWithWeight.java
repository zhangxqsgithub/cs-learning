package alg.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @link https://leetcode.cn/problems/random-pick-with-weight/
 * @author zhangxq
 * @since 2023/9/25
 */
public class P528RandomPickWithWeight {
    
    public static void main(String[] args) {
        var solution = new Solution(new int[]{1,3});
        var res1 = solution.pickIndex();
        System.out.println(res1);
    }
    
    static
    class Solution {
        int[] s;
        Random rand;
        public Solution(int[] w) {
            this.s = w;
            for (int i = 1; i < s.length; i++) s[i] += s[i - 1];
            this.rand = new Random();
        }
        public int pickIndex() {
            var x = rand.nextInt(s[s.length - 1]) + 1;
            // 返回数组中 >= x 的第一个数
            return lowerBound(s, x);
        }
        private int lowerBound(int[] nums, int x) {
            int l = 0, r = nums.length;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] < x) l = mid + 1;
                else r = mid;
            }
            return l;
        }
    }
}
