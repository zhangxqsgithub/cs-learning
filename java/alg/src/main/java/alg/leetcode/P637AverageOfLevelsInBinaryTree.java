package alg.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @link https://leetcode.cn/problems/average-of-levels-in-binary-tree/
 * @author will
 * @since 2024/3/25
 */
public class P637AverageOfLevelsInBinaryTree {
    
    public static void main(String[] args) {
    
    }
    
    public List<Double> averageOfLevels(TreeNode root) {
        var res = new ArrayList<Double>();
        if (root == null) return res;
        var queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            double sum = 0;
            for (int i = 0; i < n; i++) {
                var t = queue.poll();
                sum += t.val;
                if (t.left != null) queue.add(t.left);
                if (t.right != null) queue.add(t.right);
            }
            res.add(sum / n);
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
