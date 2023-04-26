package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/
 * @author zhangxq
 * @since 2023/4/26
 */
public class P108ConvertSortedArrayToBinarySearchTree {
    
    public static void main(String[] args) {
    
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }
    
    private TreeNode build(int[] nums, int l, int r) {
        if (l > r) return null;
        var mid = l + r >> 1;
        var root = new TreeNode(nums[mid]);
        root.left = build(nums, l, mid - 1);
        root.right = build(nums, mid + 1, r);
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
