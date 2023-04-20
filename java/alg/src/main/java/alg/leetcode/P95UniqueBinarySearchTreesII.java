package alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @link https://leetcode.cn/problems/unique-binary-search-trees-ii/
 * @author zhangxq
 * @since 2023/4/19
 */
public class P95UniqueBinarySearchTreesII {
    
    public static void main(String[] args) {
    
    }
    
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return dfs(1, n);
    }
    
    /**
     * l 和 r 表示当前区间的左右边界
     */
    public List<TreeNode> dfs(int l, int r) {
        var res = new ArrayList<TreeNode>();
        if (l > r) {
            res.add(null);
            return res;
        }
        for (int i = l; i <= r; i++) {
            var left = dfs(l, i - 1); var right = dfs(i + 1, r);
            for (var lc : left)
                for (var rc : right) {
                    var root = new TreeNode(i);
                    root.left = lc;
                    root.right = rc;
                    res.add(root);
                }
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
