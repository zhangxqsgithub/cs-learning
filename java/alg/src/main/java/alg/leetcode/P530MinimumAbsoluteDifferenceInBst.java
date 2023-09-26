package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/minimum-absolute-difference-in-bst/
 * @author zhangxq
 * @since 2023/9/26
 */
public class P530MinimumAbsoluteDifferenceInBst {
    
    public static void main(String[] args) {
        var a = new Integer[]{543,,652,null,445,null,699};
        384, 445, 543, 652, 699
    }
    
    Integer pre;
    int res = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        iter(root);
        return res;
    }
    // 二叉树的中序遍历
    private void iter(TreeNode root) {
        if (root == null) return;
        iter(root.left);
        if (pre != null) res = Math.min(res, Math.abs(root.val - pre));
        pre = root.val;
        iter(root.right);
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
