package alg.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @link https://leetcode.cn/problems/super-ugly-number/
 * @author zhangxq
 * @since 2023/5/29
 */
public class P313SuperUglyNumber {
    
    public static void main(String[] args) {
    
    }
    
    public int nthSuperUglyNumber(int n, int[] primes) {
        Queue<Pair> heap = new PriorityQueue<>(
                (o1, o2) -> o1.first.compareTo(o2.first)
        );
        for (var x : primes) heap.add(new Pair((long) x, 0L));
        long[] q = new long[n];
        q[0] = 1;
        for (int i = 1; i < n;) {
            var t = heap.poll();
            if (t.first != q[i - 1]) q[i++] = t.first;
            int idx = Math.toIntExact(t.second);
            int p = (int) (t.first / q[idx]);
            heap.add(new Pair(p * q[idx + 1], (long) (idx + 1)));
        }
        return (int) q[n - 1];
    }
    
    record Pair(Long first, Long second) {}
}
