package alg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @link https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * @author zhangxq
 * @since 2023/4/26
 */
public class P106ConstructBinaryTreeFromInorderAndPostorderTraversal {
    
    public static void main(String[] args) {
    
    }
    
    Map<Integer, Integer> pos = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 首先记录中序遍历的位置
        for (int i = 0; i < inorder.length; i++) pos.put(inorder[i], i);
        return build(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
    
    private TreeNode build(int[] inorder, int[] postorder, int il, int ir, int pl, int pr) {
        if (il > ir) return null;
        var root = new TreeNode(postorder[pr]);
        int k = pos.get(root.val);
        root.left = build(inorder, postorder, il, k - 1, pl, pl + k - 1 - il);
        root.right = build(inorder, postorder, k + 1, ir, pl + k - 1 - il + 1, pr - 1);
        return root;
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
