package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/perfect-number/
 * @author zhangxq
 * @since 2023/9/17
 */
public class P507PerfectNumber {
    
    public static void main(String[] args) {
    
    }
    
    public boolean checkPerfectNumber(int num) {
        long sum = 0;
        for (int i = 1; i <= num / i; i++) {
            if (num % i == 0) {
                if (i < num) sum += i;
                // 两个约数是否一样，若不一样并且 < num
                if (i != num / i && num / i < num) sum += num / i;
            }
        }
        return sum == num;
    }
}
