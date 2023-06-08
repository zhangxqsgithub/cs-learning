package alg.leetcode;

import java.util.*;

/**
 * @link https://leetcode.cn/problems/evaluate-division/
 * @author zhangxq
 * @since 2023/6/8
 */
public class P399EvaluateDivision {
    
    public static void main(String[] args) {
    
    }
    
    /**
     * 将每个变量看成点，所有的比值看成边，做一遍弗洛伊德算法即可
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        var vers = new HashSet<String>(); // 节点
        var d = new HashMap<String, Map<String, Double>>(); // 两点之间的距离
        for (int i = 0; i < equations.size(); i++) {
            var a = equations.get(i).get(0);
            var b = equations.get(i).get(1);
            var c = values[i];
            d.computeIfAbsent(a, m -> new HashMap<>()).put(b, c);
            d.computeIfAbsent(b, m -> new HashMap<>()).put(a, 1.0 / c);
            vers.add(a); vers.add(b);
        }
        
        for (var k : vers) {
            for (var i : vers) {
                for (var j : vers) {
                    // 从 i 到 k 存在并且从 j 到 k 存在
                    if (d.containsKey(i) && d.get(i).containsKey(k) && d.containsKey(k) && d.get(k).containsKey(j)) {
                        d
                                .computeIfAbsent(i, m -> new HashMap<>())
                                .put(j, d.get(i).get(k) * d.get(k).get(j));
                    }
                }
            }
        }
        
        var res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            var a = queries.get(i).get(0); var b = queries.get(i).get(1);
            if (d.containsKey(a) && d.get(a).containsKey(b)) res[i] = d.get(a).get(b);
            else res[i] = -1D;
        }
        return res;
    }
}
