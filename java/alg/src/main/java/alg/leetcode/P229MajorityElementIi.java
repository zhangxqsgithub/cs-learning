package alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @link https://leetcode.cn/problems/majority-element-ii/
 * @author zhangxq
 * @since 2023/5/23
 */
public class P229MajorityElementIi {
    
    public static void main(String[] args) {
    
    }
    
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length, r1 = 0, r2 = 0, c1 = 0, c2 = 0;
        for (int x : nums) {
            if (c1 != 0 && x == r1) c1++;
            else if (c2 != 0 && x == r2) c2++;
            else if (c1 == 0) { r1 = x; c1++; }
            else if (c2 == 0) { r2 = x; c2++; }
            else { c1--; c2--; }
        }
        c1 = 0; c2 = 0;
        for (int x : nums) {
            if (x == r1) c1++;
            else if (x == r2) c2++;
        }
        List<Integer> res = new ArrayList<>();
        if (c1 > n / 3) res.add(r1);
        if (c2 > n / 3) res.add(r2);
        return res;
    }
}
