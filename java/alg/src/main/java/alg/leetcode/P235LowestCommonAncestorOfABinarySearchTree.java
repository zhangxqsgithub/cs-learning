package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * @author zhangxq
 * @since 2023/5/23
 */
public class P235LowestCommonAncestorOfABinarySearchTree {
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val<p.val&&root.val<q.val) return lowestCommonAncestor(root.right,p,q);
        if(root.val>p.val&&root.val>q.val) return lowestCommonAncestor(root.left,p,q);
        return root;
    }
    
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}
