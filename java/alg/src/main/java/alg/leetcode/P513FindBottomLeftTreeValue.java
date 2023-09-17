package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/find-bottom-left-tree-value/
 * @author zhangxq
 * @since 2023/9/18
 */
public class P513FindBottomLeftTreeValue {
    
    public static void main(String[] args) {
    
    }
    
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 1);
        return bfv;
    }
    int maxDepth = 0;
    int bfv = 0;
    public void dfs(TreeNode root, int depth) {
        if (root == null) return;
        // 若遇到叶节点（左下角的节点一定是叶节点）
        if (root.left == null && root.right == null) {
            if (depth > maxDepth) {
                maxDepth = depth;
                bfv = root.val;
            }
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
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
