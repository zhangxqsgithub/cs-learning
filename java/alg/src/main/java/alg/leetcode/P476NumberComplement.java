package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/number-complement/
 * @author zhangxq
 * @since 2023/9/11
 */
public class P476NumberComplement {
    
    public static void main(String[] args) {
        var solution = new P476NumberComplement();
        var res1 = solution.findComplement(Integer.MAX_VALUE);
        System.out.println(res1);
    }
    
    public int findComplement(int num) {
        if (num == 0) return 1;
        
        // 求 num 有几个二进制位
        var n = 0;
        for (int x = num; x > 0; x >>= 1) n++;
        
        // return ~num & ((1 << n) - 1);
        // 这里用 long 计算，防止数字溢出
        return ~num & (int) ((1L << n) - 1);
    }
}
