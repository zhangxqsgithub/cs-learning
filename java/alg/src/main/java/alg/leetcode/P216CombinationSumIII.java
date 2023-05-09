package alg.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @link https://leetcode.cn/problems/combination-sum-iii/
 * @author zhangxq
 * @since 2023/5/9
 */
public class P216CombinationSumIII {
    
    public static void main(String[] args) {
    
    }
    
    List<List<Integer>> ans = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(1, n, k);
        return ans;
    }
    
    public void dfs(int start, int n, int k) {
        if (n == 0) {
            if (k == 0) ans.add(new ArrayList<>(path));
            return;
        }
        
        if (k != 0) {
            for (var i = start; i <= 9; i++) {
                if (n >= i) {
                    path.add(i);
                    dfs(i + 1, n - i, k - 1);
                    path.removeLast();
                }
            }
        }
    }
}
