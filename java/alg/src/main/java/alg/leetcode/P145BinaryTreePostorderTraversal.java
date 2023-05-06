package alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @link https://leetcode.cn/problems/binary-tree-postorder-traversal/
 * @author zhangxq
 * @since 2023/5/6
 */
public class P145BinaryTreePostorderTraversal {
    
    public static void main(String[] args) {
    
    }
    
    List<Integer> res;
    public List<Integer> postorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        if (root != null) dfs(root);
        return res;
    }
    
    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        dfs(node.right);
        res.add(node.val);
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
