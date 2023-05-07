package alg.leetcode;

import java.util.Stack;

/**
 * @author zhangxq
 * @link https://leetcode.cn/problems/binary-search-tree-iterator/
 * @since 2023/5/7
 */
public class P173BinarySearchTreeIterator {
    
    public static void main(String[] args) {
    
    }
    
    static class BSTIterator {
        Stack<TreeNode> stack = new Stack<>();
        
        public BSTIterator(TreeNode root) {
            push(root);
        }
        
        public void push(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }
        
        public int next() {
            TreeNode node = stack.pop();
            push(node.right);
            return node.val;
        }
        
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
    
    class TreeNode {
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
