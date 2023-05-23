package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/kth-smallest-element-in-a-bst/
 * @author zhangxq
 * @since 2023/5/23
 */
public class P230KthSmallestElementInABst {
    
    public static void main(String[] args) {
    
    }
    
    int k, ans;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return ans;
    }
    
    public boolean dfs(TreeNode root) {
        if (root == null) return false;
        if (dfs(root.left)) return true;
        if (--k == 0) {
            ans = root.val;
            return true;
        }
        return dfs(root.right);
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
