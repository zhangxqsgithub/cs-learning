package alg.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @link https://leetcode.cn/problems/random-flip-matrix/
 * @author zhangxq
 * @since 2023/9/22
 */
public class P519RandomFlipMatrix {
    
    public static void main(String[] args) {
        var solution = new Solution(5, 5);
        var res1 = solution.flip();
        System.out.println(Arrays.toString(res1));
    }
    
    static
    class Solution {
        int m, n, k; // k 表示当前剩余的总元素数
        // hash 表存所有的特殊值
        Map<Integer, Integer> map;
        Random rand;
        public Solution(int m, int n) {
            this.m = m;
            this.n = n;
            this.k = m * n;
            this.map = new HashMap<>();
            this.rand = new Random();
        }
        public int[] flip() {
            int x = rand.nextInt(k);
            int y = x;
            if (map.containsKey(x)) y = map.get(x);
            if (map.containsKey(k - 1)) {
                map.put(x, map.get(k - 1));
                map.remove(k - 1);
            }
            else {
                map.put(x, k - 1);
            }
            k--;
            return new int[]{y / n, y % n};
        }
        public void reset() {
            this.k = m * n;
            this.map.clear();
        }
    }
}
