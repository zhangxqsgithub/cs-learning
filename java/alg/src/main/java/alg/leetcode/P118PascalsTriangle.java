package alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangxq
 * @link https://leetcode.cn/problems/pascals-triangle/
 * @since 2023/4/27
 */
public class P118PascalsTriangle {
    
    public static void main(String[] args) {
    
    }
    
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> f = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            var line = new Integer[i + 1];
            line[0] = line[i] = 1;
            for (int j = 1; j < i; j++) {
                line[j] = f.get(i - 1).get(j - 1) + f.get(i - 1).get(j);
            }
            f.add(List.of(line));
        }
        return f;
    }
}
