package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/count-complete-tree-nodes/
 * @author zhangxq
 * @since 2023/5/22
 */
public class P222CountCompleteTreeNodes {
    
    public static void main(String[] args) {
    
    }
    
    /**
     * 判断树是否是满二叉树，若是满二叉树直接可以计算出节点个数；
     * 递归判断左右子树是否是满二叉树，
     *    若左右子树都会满二叉树，则可直接计算出节点个数。
     *    若左右子树有且只有一颗不是满二叉树，则递归找到左右子树都是满二叉树的情况。
     */
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int l = 1, r = 1;
        for (var n = root.left; n != null; n = n.left) l++;
        for (var n = root.right; n != null; n = n.right) r++;
        if (l == r) return (1 << l) - 1;
        return countNodes(root.left) + 1 + countNodes(root.right);
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
