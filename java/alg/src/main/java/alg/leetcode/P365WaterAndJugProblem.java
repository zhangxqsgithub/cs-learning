package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/water-and-jug-problem/
 * @author zhangxq
 * @since 2023/6/1
 */
public class P365WaterAndJugProblem {
    
    public static void main(String[] args) {
    
    }
    
    public boolean canMeasureWater(int a, int b, int c) {
        // 判断 a 和 b 的最大公约数是否能整除 c
        if (c > a + b) return false;
        return c == 0 || c % gcd(a, b) == 0;
    }
    public int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }
    
}
