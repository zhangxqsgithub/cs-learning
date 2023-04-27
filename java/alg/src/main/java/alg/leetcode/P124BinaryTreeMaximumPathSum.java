package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/binary-tree-maximum-path-sum/
 * @author zhangxq
 * @since 2023/4/27
 */
public class P124BinaryTreeMaximumPathSum {
    
    public static void main(String[] args) {
    
    }
    
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }
    
    public int dfs(TreeNode u) {
        if (u == null) return 0;
        int left = Math.max(0, dfs(u.left)), right = Math.max(0, dfs(u.right));
        ans = Math.max(ans, u.val + left + right);
        return u.val + Math.max(left, right);
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
