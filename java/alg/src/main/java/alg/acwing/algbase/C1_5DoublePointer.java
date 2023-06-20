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
    }
    // 离散化
    // 区间合并
}
