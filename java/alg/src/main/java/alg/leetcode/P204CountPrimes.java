package alg.leetcode;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author zhangxq
 * @link https://leetcode.cn/problems/count-primes/
 * @since 2023/5/8
 */
public class P204CountPrimes {
    
    public static void main(String[] args) {
    
    }
    
    public int countPrimes(int n) {
        var st = new boolean[n];
        var primes = new ArrayList<Integer>();
        for (var i = 2; i < n; i++) {
            if (!st[i]) primes.add(i);
            for (var j = 0; i * primes.get(j) < n; j++) {
                st[i * primes.get(j)] = true;
                if (i % primes.get(j) == 0) break;
            }
        }
        return primes.size();
    }
}
