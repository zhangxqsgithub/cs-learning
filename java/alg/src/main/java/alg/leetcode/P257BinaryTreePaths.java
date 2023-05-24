package alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @link https://leetcode.cn/problems/binary-tree-paths/
 * @author zhangxq
 * @since 2023/5/24
 */
public class P257BinaryTreePaths {
    
    public static void main(String[] args) {
    
    }
    
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, String.valueOf(root.val));
        return res;
    }
    
    public void dfs(TreeNode root, String path) {
        if (root.left == null && root.right == null) {
            res.add(path);
            return;
        }
        if (root.left != null) dfs(root.left, path + "->" + root.left.val);
        if (root.right != null) dfs(root.right, path + "->" + root.right.val);
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
