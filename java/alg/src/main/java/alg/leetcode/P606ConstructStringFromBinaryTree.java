package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/construct-string-from-binary-tree/
 * @author zhangxq
 * @since 2023/10/6
 */
public class P606ConstructStringFromBinaryTree {
    
    public static void main(String[] args) {
        var solution = new P606ConstructStringFromBinaryTree();
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        var res1 = solution.tree2str(root1);
        System.out.println(res1);
    }
    
    public String tree2str(TreeNode root) {
        if (root == null) return "";
        var res = String.valueOf(root.val);
        if (root.left != null || root.right != null) res += "(" + tree2str(root.left) + ")";
        if (root.right != null) res += "(" + tree2str(root.right) + ")";
        return res;
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
