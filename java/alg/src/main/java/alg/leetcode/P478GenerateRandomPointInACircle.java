package alg.leetcode;

import java.util.Random;

/**
 * @link https://leetcode.cn/problems/generate-random-point-in-a-circle/
 * @author zhangxq
 * @since 2023/9/11
 */
public class P478GenerateRandomPointInACircle {
    
    public static void main(String[] args) {
    
    }
    
    static
    class Solution {
        public double r, x, y;
        public Solution(double radius, double x_center, double y_center) {
            r = radius; x = x_center; y = y_center;
        }
        public double[] randPoint() {
            // 先将圆示为圆心为 0 半径为 1 的
            var random = new Random();
            var a = random.nextDouble() * 2 - 1;
            var b = random.nextDouble() * 2 - 1;
            // 如果在圆内
            if (a * a + b * b > 1) return randPoint();
            return new double[]{x + r * a, y + r * b};
        }
    }
}
