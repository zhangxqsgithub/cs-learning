package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/merge-two-binary-trees/
 * @author zhangxq
 * @since 2023/10/11
 */
public class P617MergeTwoBinaryTrees {
    
    public static void main(String[] args) {
    
    }
    
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;
        if (root1 == null) { root1 = root2; root2 = null; } // 确保 root1 不为空
        // 将值合并到 root1 中
        if (root2 != null) root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2 != null ? root2.left : null);
        root1.right = mergeTrees(root1.right, root2 != null ? root2.right : null);
        return root1;
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
