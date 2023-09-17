package alg;

/**
 * @author zhangxq
 * @since 2023/9/17
 */
public class MyMath {
    
    public static int min(int... nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) min = Math.min(min, num);
        return min;
    }
    
    public static int max(int... nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) max = Math.max(max, num);
        return max;
    }
}
