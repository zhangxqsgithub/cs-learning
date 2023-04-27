package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/sum-root-to-leaf-numbers/
 * @author zhangxq
 * @since 2023/4/27
 */
public class P129SumRootToLeafNumbers {
    
    public static void main(String[] args) {
    
    }
    
    int ans = 0;
    public int sumNumbers(TreeNode root) {
        if (root != null) dfs(root, 0);
        return ans;
    }
    
    private void dfs(TreeNode root, int u) {
        u = u * 10 + root.val;
        if (root.left == null && root.right == null) ans += u;
        if (root.left != null) dfs(root.left, u);
        if (root.right != null) dfs(root.right, u);
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
