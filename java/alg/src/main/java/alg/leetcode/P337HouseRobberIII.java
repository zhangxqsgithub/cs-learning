package alg.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @link https://leetcode.cn/problems/house-robber-iii/
 * @author zhangxq
 * @since 2023/5/31
 */
public class P337HouseRobberIII {
    
    public static void main(String[] args) {
    
    }
    
    public int rob(TreeNode root) {
        var res = dfs(root);
        return Math.max(res.get(0), res.get(1));
    }
    
    List<Integer> dfs(TreeNode u) {
        if (u == null) return Arrays.asList(0, 0);
        var x = dfs(u.left);
        var y = dfs(u.right);
        return Arrays.asList(
                Math.max(x.get(0), x.get(1))+Math.max(y.get(0), y.get(1)),
                x.get(0) + y.get(0) + u.val
        );
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
