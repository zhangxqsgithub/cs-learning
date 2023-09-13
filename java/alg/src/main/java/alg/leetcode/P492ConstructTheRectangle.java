package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/construct-the-rectangle/
 * @author zhangxq
 * @since 2023/9/13
 */
public class P492ConstructTheRectangle {
    
    public static void main(String[] args) {
    
    }
    
    public int[] constructRectangle(int area) {
        // 从 根下 n 到 1 枚举
        for (int i = (int) Math.sqrt(area); ; i--)
            if (area % i == 0)
                return new int[]{area / i, i};
    }
}
