package alg.acwing_course.base;

/**
 * 位运算
 *
 * @author will
 * @since 2024/3/28
 */
public class C107BitwiseOperation {
    
    public static void main(String[] args) {
        System.out.println(-16 >> 3);
        System.out.println(1 << 3);
        System.out.println(-16 >>> 3);
        System.out.println(1 | 0);
        System.out.println(1 & 0);
        System.out.println(1 ^ 0);
        
        var solution = new C107BitwiseOperation();
        int n = 48, k = 3;
        // 求 n 的第 k 位数字
        System.out.println(n >> k & 1);
        // 返回 n 的最后一位 1 和后面的 0 组成的数字：lowbit 方法
        // 1010    返回 10
        // 1010000 返回 10000
        System.out.println(n & -n);
        
        solution.printBinary(48);
        // 负数用补码表示，原码 -> 反码 通过每位二进制取反获得，反码再 + 1 得到补码。
        solution.printBinary(-48);
        
        System.out.println(solution.countOneBinary(48));
    }
    
    public void printBinary(int x) {
        for (int k = 31; k >= 0; k--) System.out.print(x >> k & 1);
        System.out.println();
    }
    
    // 统计数字 k 的二进制表示中 1 出现的次数
    public int countOneBinary(int k) {
        int res = 0;
        while (k != 0) {
            k -= lowbit(k);
            res++;
        }
        return res;
    }
    
    /**
     * lowbit 算法（树状数组的基本操作）
     * 返回数字 x 的二进制表示中，仅保留最后一位 1 所代表的数字。
     */
    public int lowbit(int x) {
        return x & -x;
    }

}
