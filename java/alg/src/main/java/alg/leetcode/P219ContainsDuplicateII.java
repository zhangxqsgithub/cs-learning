package alg.leetcode;

import java.util.HashMap;

/**
 * @link https://leetcode.cn/problems/contains-duplicate-ii/
 * @author zhangxq
 * @since 2023/5/20
 */
public class P219ContainsDuplicateII {
    
    public static void main(String[] args) {
    
    }
    
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();
        for (var i = 0; i < nums.length; i++) {
            var x = nums[i];
            // 判断数组中是否存在两个相同的数，使得两个数下标相减的绝对不超过 k。
            if (map.containsKey(x) && i - map.get(x) <= k) return true;
            map.put(x, i);
        }
        return false;
    }
}
