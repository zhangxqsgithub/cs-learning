package alg.acwing_course.base;

/**
 * 双指针
 * 核心思想：
 * <blockquote><pre>
 *     for (int i = 0; i < n; i++) {
 *         for (int j = 0; j < m; j++) {
 *             // 时间复杂度 O(n^2)
 *         }
 *     }
 * </pre></blockquote>
 * 将上面的朴素算法的时间复杂度优化到 O(n)。
 * @author zhangxq
 * @since 2023/6/20
 */
public class C106DoublePointer {
    
    public static void main(String[] args) {
        var solution = new C106DoublePointer();
        var res1 = solution.doublePointer(new int[]{1, 2, 3, 4, 6});
        System.out.println(res1);
    }
    
    /**
     * 最长递增序列问题
     */
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
}
