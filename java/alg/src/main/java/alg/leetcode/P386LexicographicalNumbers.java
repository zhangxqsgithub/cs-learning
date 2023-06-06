package alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @link https://leetcode.cn/problems/lexicographical-numbers/
 * @author zhangxq
 * @since 2023/6/6
 */
public class P386LexicographicalNumbers {
    
    public static void main(String[] args) {
    
    }
    
    List<Integer> res;
    public List<Integer> lexicalOrder(int n) {
        res = new ArrayList<>();
        for (int i = 1; i <= 9; i++) dfs(i, n);
        return res;
    }
    public void dfs(int cur, int n) {
        if (cur > n) return;
        res.add(cur);
        for (int i = 0; i <= 9; i++) dfs(cur * 10 + i, n);
    }
}
