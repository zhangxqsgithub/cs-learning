package alg.leetcode;

import java.util.*;

/**
 * @link https://leetcode.cn/problems/subsets-ii/
 * @author zhangxq
 * @since 2023/4/19
 */
public class P90SubsetsII {
    
    public static void main(String[] args) {
    
    }
    
    Map<Integer, Integer> cnt = new HashMap<>();
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 累积数字出现的次数
        for (int num : nums) cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        dfs(-10);
        return ans;
    }
    
    public void dfs(int u) {
        // 结束条件是 > 10
        if (u > 10) {
            ans.add(new ArrayList<>(path));
            return;
        }
        
        for (int i = 0; i < cnt.getOrDefault(u, 0) + 1; i++) {
            dfs(u + 1);
            path.push(u);
        }
        // 最后要清理
        for (int i = 0; i < cnt.getOrDefault(u, 0) + 1; i ++) {
            path.pop();
        }
    }
}
