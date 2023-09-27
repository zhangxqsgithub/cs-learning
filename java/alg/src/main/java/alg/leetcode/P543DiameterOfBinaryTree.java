package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/diameter-of-binary-tree/
 * @author zhangxq
 * @since 2023/9/27
 */
public class P543DiameterOfBinaryTree {
    
    public static void main(String[] args) {
    
    }
    
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        var l = dfs(root.left);
        var r = dfs(root.right);
        ans = Math.max(ans, l + r);
        return Math.max(l, r) + 1;
    }
    
    class TreeNode {
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
