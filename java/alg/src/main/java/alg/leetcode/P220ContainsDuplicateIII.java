package alg.leetcode;

import java.util.TreeSet;

/**
 * @link https://leetcode.cn/problems/contains-duplicate-iii/
 * @author zhangxq
 * @since 2023/5/20
 */
public class P220ContainsDuplicateIII {
    
    public static void main(String[] args) {
    
    }
    
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        var set = new TreeSet<Long>();
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (i - j > k) set.remove((long) nums[j++]);
            var x = nums[i];
            // 找 >= x 的最小数
            var it = set.ceiling((long) x);
            if (it != null && it - x <= t) return true;
            // < x 的最大数
            it = set.lower((long) x);
            if (it != null && x - it <= t) return true;
            set.add((long) x);
        }
        return false;
    }
}
