package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/subtree-of-another-tree/
 * @author zhangxq
 * @since 2023/9/29
 */
public class P572SubtreeOfAnotherTree {
    
    public static void main(String[] args) {
    
    }
    
    /**
     * 树的 hash 函数
     */
    int P = 131, Q = 159, MOD = (int) 10e7 + 7;
    int T = -1; // 初始化的 hash 值
    boolean ans = false;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        T = dfs(subRoot);
        if (T == dfs(root)) ans = true;
        return ans;
    }
    private int dfs(TreeNode root) {
        if (root == null) return 123456;
        int left = dfs(root.left), right = dfs(root.right);
        int x = (root.val % MOD + MOD) % MOD;
        if (left == T || right == T) ans = true;
        return (x + left * P % MOD + right * Q % MOD) % MOD;
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
