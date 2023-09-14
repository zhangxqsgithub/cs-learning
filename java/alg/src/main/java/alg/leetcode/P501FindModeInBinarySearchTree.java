package alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangxq
 * @link https://leetcode.cn/problems/find-mode-in-binary-search-tree/
 * @since 2023/9/14
 */
public class P501FindModeInBinarySearchTree {
    
    public static void main(String[] args) {
    
    }
    
    // 记录前一段的数字是多少
    int last = Integer.MIN_VALUE;
    // 记录当前这个数字一共出现多少次
    int curCnt = 0;
    // 记录出现数字最多的次数
    int maxCnt = 0;
    List<Integer> list = new ArrayList<>();
    
    public int[] findMode(TreeNode root) {
        dfs(root);
        var res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    
    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        int x = root.val;
        if (x == last) {
            curCnt++;
        }
        else {
            last = x;
            curCnt = 1;
        }
        if (curCnt > maxCnt) {
            list.clear();
            maxCnt = curCnt;
            list.add(x);
        }
        else if (curCnt == maxCnt) {
            list.add(x);
        }
        dfs(root.right);
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
