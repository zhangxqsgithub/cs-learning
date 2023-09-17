package alg.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @link https://leetcode.cn/problems/most-frequent-subtree-sum/
 * @author zhangxq
 * @since 2023/9/17
 */
public class P508MostFrequentSubtreeSum {
    
    public static void main(String[] args) {
    
    }
    
    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        var res = new int[list.get(list.size() - 1).size()];
        for (int i = 0; i < list.get(list.size() - 1).size(); i++) {
            res[i] = list.get(list.size() - 1).get(i);
        }
        return res;
    }
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int sum = left + right + root.val;
        // 统计 sum 出现的次数
        count(sum);
        return sum;
    }
    Map<Integer, Integer> map = new HashMap<>();
    List<List<Integer>> list = new ArrayList<>();
    private void count(int num) {
        map.put(num, map.getOrDefault(num, 0) + 1);
        
        int count = map.get(num);
        int idx = count - 1;
        if (list.size() < count) list.add(new ArrayList<>());
        list.get(idx).add(num);
    }
    class TreeNode {
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
