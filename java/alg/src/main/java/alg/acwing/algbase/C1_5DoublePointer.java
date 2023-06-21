package alg.acwing.algbase;

/**
 * 双指针
 * @author zhangxq
 * @since 2023/6/20
 */
public class C1_5DoublePointer {
    
    public static void main(String[] args) {
        var solution = new C1_5DoublePointer();
        solution.bit();
    }
    
    // 双指针
    // 最长递增序列问题
    public int doublePointer(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int j = i + 1;
            while (j < arr.length && arr[j] == arr[j - 1] + 1) j++;
            res = Math.max(res, j - i);
            i = j - 1;
        }
        return res;
    }
    // 位运算
    public void bit() {
        System.out.println(-16 >> 3);
        System.out.println(1 << 3);
        System.out.println(-16 >>> 3);
        System.out.println(1 | 0);
        System.out.println(1 & 0);
        System.out.println(1 ^ 0);
        
        int n = 48, k = 3;
        // 求 n 的第 k 位数字
        System.out.println(n >> k & 1);
        // 返回 n 的最后一位 1 和后面的 0 组成的数字：lowbit 方法
        // 1010    返回 10
        // 1010000 返回 10000
        System.out.println(n & -n);
        
        printBinary(48);
        printBinary(-48); // 负数用补码表示，原码 -> 反码 通过每位二进制取反获得，反码再 + 1 得到补码。
    }
    public void printBinary(int x) {
        for (int k = 31; k >= 0; k--) System.out.print(x >> k & 1);
        System.out.println();
    }
    // 离散化
    // 区间合并
}
