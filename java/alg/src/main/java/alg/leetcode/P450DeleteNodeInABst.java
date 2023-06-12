package alg.leetcode;

/**
 * @author zhangxq
 * @link https://leetcode.cn/problems/delete-node-in-a-bst/
 * @since 2023/6/12
 */
public class P450DeleteNodeInABst {
    
    public static void main(String[] args) {
    
    }
    
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key == root.val) {
            if (root.left == null && root.right == null) root = null;
            else if (root.left == null) root = root.right;
            else if (root.right == null) root = root.left;
            else {
                var p = root.right;
                while (p.left != null) p = p.left;
                root.val = p.val;
                root.right = deleteNode(root.right, p.val);
            }
        }
        else if (key < root.val) root.left = deleteNode(root.left, key);
        else root.right = deleteNode(root.right, key);
        return root;
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode() {
        }
        
        TreeNode(int val) {
            this.val = val;
        }
        
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
