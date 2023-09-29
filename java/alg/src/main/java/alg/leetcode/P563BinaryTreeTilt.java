package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/binary-tree-tilt/
 * @author zhangxq
 * @since 2023/9/29
 */
public class P563BinaryTreeTilt {
    
    public static void main(String[] args) {
    
    }
    
    int ans = 0;
    public int findTilt(TreeNode root) {
        dfs(root);
        return ans;
    }
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        ans += Math.abs(l - r);
        return l + r + root.val;
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
