package alg.leetcode;

import java.util.*;

/**
 * @link https://leetcode.cn/problems/binary-tree-right-side-view/
 * @author zhangxq
 * @since 2023/5/8
 */
public class P199BinaryTreeRightSideView {
    
    public static void main(String[] args) {
    
    }
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        if (root != null) que.add(root);
        while (!que.isEmpty()) {
            Integer last = null;
            for (int i = que.size(); i > 0; i--) {
                var node = que.poll();
                if (node == null) continue;
                last = node.val;
                if (node.left != null) que.add(node.left);
                if (node.right != null) que.add(node.right);
            }
            res.add(last);
        }
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
