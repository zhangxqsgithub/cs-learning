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
            int j = i + 1;
            while (j < nums.length && nums[j] == nums[j - 1] + 1) j++;
            if (j == i + 1) res.add(String.valueOf(n));
            else res.add(n + "->" + nums[j - 1]);
            i = j - 1;
        }
        return res;
    }
}
