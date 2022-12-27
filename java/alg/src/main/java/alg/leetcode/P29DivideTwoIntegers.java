package alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 两数相除
 *
 * @author zhangxq
 * @link https://leetcode.cn/problems/divide-two-integers/
 * @since 2022/12/27
 */
public class P29DivideTwoIntegers {
    
    /**
     * @param x 被除数
     * @param y 除数
     */
    public int divide(int x, int y) {
        // 标记结果是否为负数
        var isMinus = false;
        if ( (x < 0 && y > 0) || (x > 0 && y < 0) ) isMinus = true;
        
        long a = Math.abs((long) x), b = Math.abs((long) y);
        
        // exp[i] = b * 2^i
        List<Long> exp = new ArrayList<>();
        for (var i = b; i <= a; i = i + i) exp.add(i);
        
        long res = 0;
        for (var i = exp.size() - 1; i >= 0; i--) {
            if (a >= exp.get(i)) {
                a -= exp.get(i);
                res += 1L << i;
            }
        }
        if (isMinus) res = -res;
        if (res >Integer.MAX_VALUE || res< Integer.MIN_VALUE) return Integer.MAX_VALUE;
        return (int) res;
    }
    
}
