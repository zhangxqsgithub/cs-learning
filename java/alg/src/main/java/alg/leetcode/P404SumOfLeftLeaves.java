package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/sum-of-left-leaves/
 * @author zhangxq
 * @since 2023/6/8
 */
public class P404SumOfLeftLeaves {
    
    public static void main(String[] args) {
    
    }
    
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root);
        return sum;
    }
    public void dfs(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            }
        }
        dfs(root.left);
        dfs(root.right);
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
