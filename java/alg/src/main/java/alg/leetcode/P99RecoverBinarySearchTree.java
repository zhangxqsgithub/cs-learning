package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/recover-binary-search-tree/
 * @author zhangxq
 * @since 2023/4/20
 */
public class P99RecoverBinarySearchTree {
    
    public static void main(String[] args) {
    
    }
    
    /**
     * Morris 遍历方法
     */
    public void recoverTree(TreeNode root) {
        TreeNode first = null, second = null, last = null;
        while (root != null) {
            if (root.left == null) {
                if (last != null && last.val > root.val) {
                    if (first == null) { first = last; second = root; }
                    else second = root;
                }
                last = root;
                root = root.right;
            }
            else {
                var p = root.left;
                while (p.right != null && p.right != root) p = p.right;
                if (p.right == null) { p.right = root; root = root.left; }
                else {
                    p.right = null;
                    if (last != null && last.val > root.val) {
                        if (first == null) { first = last; second = root; }
                        else second = root;
                    }
                    last = root;
                    root = root.right;
                }
            }
        }
        var t = first.val;
        first.val = second.val;
        second.val = t;
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
