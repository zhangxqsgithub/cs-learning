package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/
 * @author zhangxq
 * @since 2023/4/27
 */
public class P114FlattenBinaryTreeToLinkedList {
    
    public static void main(String[] args) {
    
    }
    
    public void flatten(TreeNode root) {
        while (root != null) {
            var p = root.left;
            if (p != null) {
                while (p.right != null) p = p.right;
                p.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
    
    public class TreeNode {
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
