package alg.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @link https://leetcode.cn/problems/contains-duplicate/
 * @author zhangxq
 * @since 2023/5/9
 */
public class P217ContainsDuplicate {
    
    public static void main(String[] args) {
    
    }
    
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }
}
