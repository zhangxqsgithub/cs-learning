package alg.acwing;

import alg.Pair;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 耍杂技的牛
 *
 * @link https://www.acwing.com/problem/content/127/
 * @author will
 * @since 2024/5/21
 */
public class P125 {
    
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        var cows = new Pair[n];
        for (int i = 0; i < n; i++) {
            int w = sc.nextInt(), s = sc.nextInt();
            cows[i] = new Pair(w + s, w);
        }
        Arrays.sort(cows, (a, b) -> Integer.compare(a.first, b.first));
        int sum = 0, res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int w = cows[i].second, s = cows[i].first - cows[i].second;
            res = Math.max(res, sum - s);
            sum += w;
        }
        System.out.println(res);
    }
    static class Pair {
        int first, second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
