package alg.leetcode;

import java.util.*;

/**
 * @author zhangxq
 * @link https://leetcode.cn/problems/non-decreasing-subsequences/
 * @since 2023/9/13
 */
public class P491NonDecreasingSubsequences {
    
    public static void main(String[] args) {
        var solution = new P491NonDecreasingSubsequences();
        solution.findSubsequences(new int[]{4, 6, 7, 7});
    }
    
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(nums, 0);
        return ans;
    }
    private void dfs(int[] nums, int start) {
        if (path.size() >= 2) ans.add(new ArrayList<>(path));
        if (start == nums.length) return;
        // 每一层做缓存
        var s = new HashSet<Integer>();
        for (int i = start; i < nums.length; i++)
            if (path.isEmpty() || path.getLast() <= nums[i]) {
                if (s.contains(nums[i])) continue;
                s.add(nums[i]);
                path.addLast(nums[i]);
                dfs(nums, i + 1);
                path.removeLast();
            }
    }
}
