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
        solution.splitWord("abc def ghi");
        
        var res1 = solution.doublePointer(new int[]{1, 2, 3, 4, 6});
        System.out.println(res1);
    }
    
    /**
     * 按照空格分割单词
     */
    public void splitWord(String str) {
        for (int i = 0; i < str.length(); i++) {
            int j = i; // j 是第二个指针
            while (j < str.length() && str.charAt(j) != ' ') j++;
            System.out.println(str.substring(i, j));
            i = j + 1;
        }
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
    
    /**
     * 最长连续不重复子序列
     * @link https://www.acwing.com/problem/content/description/801/
     */
    public int doublePointer2(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int j = i + 1;
            while (j < arr.length && arr[j - 1] != arr[j] && arr[j - 1] < arr[j]) j++;
            res = Math.max(res, j - i);
            i = j - 1;
        }
        return res;
    }
}
