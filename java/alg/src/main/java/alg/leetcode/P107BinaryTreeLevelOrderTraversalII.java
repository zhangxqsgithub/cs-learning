package alg.leetcode;

import java.util.*;

/**
 * @link https://leetcode.cn/problems/binary-tree-level-order-traversal-ii/
 * @author zhangxq
 * @since 2023/4/26
 */
public class P107BinaryTreeLevelOrderTraversalII {
    
    public static void main(String[] args) {
    
    }
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        if (root != null) que.add(root);
        while (!que.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            for (int i = que.size(); i > 0; i--) {
                var itm = que.poll();
                if (itm == null) continue;
                level.add(itm.val);
                if (itm.left != null) que.add(itm.left);
                if (itm.right != null) que.add(itm.right);
            }
            res.add(level);
        }
        Collections.reverse(res);
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


