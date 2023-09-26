package alg.leetcode;

/**
 * 把二叉搜索树转换为累加树
 * @link https://leetcode.cn/problems/convert-bst-to-greater-tree/
 * @author zhangxq
 * @since 2023/9/26
 */
public class P538ConvertBstToGreaterTree {
    
    public static void main(String[] args) {
    
    }
    
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
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
