package alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @link https://leetcode.cn/problems/summary-ranges/
 * @author zhangxq
 * @since 2023/5/23
 */
public class P228SummaryRanges {
    
    public static void main(String[] args) {
        var s = "1->2";
        System.out.println(s.lastIndexOf("->"));
    }
    
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) return res;
        for (var i = 0; i < nums.length; i++) {
            int n = nums[i];
            int x = n, j = i;
            while (j < nums.length && nums[j] == x) { x++; j++; }
            if (n != x - 1) res.add(n + "->" + (x - 1));
            else res.add(String.valueOf(n));
            i = j - 1;
        }
        return res;
    }
}
