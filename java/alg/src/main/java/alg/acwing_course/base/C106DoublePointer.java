package alg.acwing_course.base;

/**
 * 双指针
 *
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
