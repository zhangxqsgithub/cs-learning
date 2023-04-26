package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/balanced-binary-tree/
 * @author zhangxq
 * @since 2023/4/26
 */
public class P110BalancedBinaryTree {
    
    public static void main(String[] args) {
    
    }
    
    boolean ans = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return ans;
    }
    
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int lh = dfs(root.left), rh = dfs(root.right);
        if (Math.abs(lh - rh) > 1) ans = false;
        return Math.max(lh, rh) + 1;
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
