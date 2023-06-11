package alg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @link https://leetcode.cn/problems/path-sum-iii/
 * @author zhangxq
 * @since 2023/6/12
 */
public class P437PathSumIII {
    
    public static void main(String[] args) {
    
    }
    
    Map<Long, Integer> cnt = new HashMap<>();
    int res = 0;
    public int pathSum(TreeNode root, int targetSum) {
        cnt.put(0L, 1);
        dfs(root, targetSum, 0);
        return res;
    }
    public void dfs(TreeNode root, int sum, long cur) {
        if (root == null) return;
        cur += root.val;
        res += cnt.getOrDefault(cur - sum, 0);
        cnt.put(cur, cnt.getOrDefault(cur, 0) + 1);
        dfs(root.left, sum, cur);
        dfs(root.right, sum, cur);
        cnt.put(cur, cnt.getOrDefault(cur, 0) - 1);
    }
    
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }
}
