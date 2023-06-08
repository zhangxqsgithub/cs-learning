package alg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @link https://leetcode.cn/problems/integer-replacement/
 * @author zhangxq
 * @since 2023/6/8
 */
public class P397IntegerReplacement {
    
    public static void main(String[] args) {
        System.out.println(1 / 2);
    }
    
    // 加一个 cache 避免重复搜索。时间复杂度为 根下 n
    Map<Long, Integer> map = new HashMap<>();
    public int integerReplacement(int n) {
        return f(n);
    }
    public int f(long n) {
        if (map.containsKey(n)) return map.get(n);
        if (n == 1) return 0;
        int res = 0;
        if (n % 2 == 0) res = f(n / 2) + 1;
        else res = Math.min(f(n - 1), f(n + 1)) + 1;
        map.put(n, res);
        return res;
    }
}
