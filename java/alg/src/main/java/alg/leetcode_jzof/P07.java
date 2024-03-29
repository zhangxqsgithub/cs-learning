package alg.leetcode_jzof;

import java.util.HashMap;

/**
 * @author zail
 * @date 2022/7/21
 */
public class P07 {
    
    public static void main(String[] args) {
    
    }
    
    int[] preorder;
    HashMap<Integer, Integer> dic = new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++)
            dic.put(inorder[i], i);
        return recur(0, 0, inorder.length - 1);
    }
    
    TreeNode recur(int root, int left, int right) {
        if (left > right) return null;                                   // 递归终止
        TreeNode node = new TreeNode(preorder[root]);                    // 建立根节点
        int i = dic.get(preorder[root]);                                 // 划分根节点、左子树、右子树
        node.left = recur(root + 1, left, i - 1);              // 开启左子树递归
        node.right = recur(root + i - left + 1, i + 1, right);  // 开启右子树递归
        return node;                                                     // 回溯返回根节点
    }
    
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int x) {
            val = x;
        }
    }
}
