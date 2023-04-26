package alg.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @link https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/
 * @author zhangxq
 * @since 2023/4/26
 */
public class P103BinaryTreeZigzagLevelOrderTraversal {
    
    public static void main(String[] args) {
    }
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> que = new LinkedList<>();
        if (root != null) que.add(root);
        int level = 0;
        while (!que.isEmpty()) {
            List<Integer> l = new ArrayList<>();
            for (int i = que.size(); i > 0; i--) {
                TreeNode itm = que.poll();
                if (itm == null) continue;
                l.add(itm.val);
                if (itm.left != null) que.add(itm.left);
                if (itm.right != null) que.add(itm.right);
            }
            if (++level % 2 == 0) Collections.reverse(l);
            res.add(l);
        }
        return res;
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
