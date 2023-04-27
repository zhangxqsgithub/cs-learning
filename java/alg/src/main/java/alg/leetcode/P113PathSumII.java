package alg.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @link https://leetcode.cn/problems/path-sum-ii/
 * @author zhangxq
 * @since 2023/4/27
 */
public class P113PathSumII {
    
    public static void main(String[] args) {
    
    }
    
    List<List<Integer>> ans = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root != null) dfs(root, targetSum);
        return ans;
    }
    
    public void dfs(TreeNode root, int sum) {
        path.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null) {
            if (sum == 0) ans.add(new ArrayList<>(path));
        }
        else {
            if (root.left != null) dfs(root.left, sum);
            if (root.right != null) dfs(root.right, sum);
        }
        path.pollLast();
    }
    
    public class TreeNode {
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
