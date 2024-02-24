package alg.leetcode;

import java.util.LinkedList;

/**
 * @author zhangxq
 * @link https://leetcode.cn/problems/add-one-row-to-tree/
 * @since 2024/2/24
 */
public class P623AddOneRowToTree {
    
    public static void main(String[] args) {
    
    }
    
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        // 特判
        if (depth == 1) {
            var cur = new TreeNode(val);
            cur.left = root;
            return cur;
        }
        
        var queue = new LinkedList<TreeNode>();
        queue.add(root);
        // 循环 depth - 2 次
        for (int i = 0; i < depth - 2; i++) {
            for (int j = queue.size(); j > 0; j--) {
                var cur = queue.poll();
                if (cur == null) continue;
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
        }
        // 最后循环处理队列里的元素
        while (!queue.isEmpty()) {
            var t = queue.poll();
            var left = new TreeNode(val); var right = new TreeNode(val);
            left.left = t.left; right.right = t.right;
            t.left = left; t.right = right;
        }
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
