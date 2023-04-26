package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/path-sum/
 * @author zhangxq
 * @since 2023/4/26
 */
public class P112PathSum {
    
    public static void main(String[] args) {
    
    }
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        targetSum -= root.val;
        if (root.left == null && root.right == null) return targetSum == 0;
        return root.left != null && hasPathSum(root.left, targetSum)
                || root.right != null && hasPathSum(root.right, targetSum);
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
