package alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangxq
 * @link https://leetcode.cn/problems/ugly-number-ii/
 * @since 2023/5/25
 */
public class P264UglyNumberII {
    
    public static void main(String[] args) {
    
    }
    
    public int nthUglyNumber(int n) {
        List<Integer> q = new ArrayList<>();
        q.add(1);
        for (int i2 = 0, i3 = 0, i5 = 0; q.size() < n; ) {
            int t = Math.min(q.get(i2) * 2, Math.min(q.get(i3) * 3, q.get(i5) * 5));
            q.add(t);
            if (t == q.get(i2) * 2) i2++;
            if (t == q.get(i3) * 3) i3++;
            if (t == q.get(i5) * 5) i5++;
        }
        return q.get(n - 1);
    }
    
}
