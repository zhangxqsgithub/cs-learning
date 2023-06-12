package alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @link https://leetcode.cn/problems/find-all-duplicates-in-an-array/
 * @author zhangxq
 * @since 2023/6/12
 */
public class P442FindAllDuplicatesInAnArray {
    
    public static void main(String[] args) {
    
    }
    
    public List<Integer> findDuplicates(int[] nums) {
        var res = new ArrayList<Integer>();
        for (var x : nums) {
            int p = Math.abs(x) - 1;
            nums[p] *= -1;
            if (nums[p] > 0) res.add(Math.abs(x));
        }
        return res;
    }
}
