package alg.acwing_course.base;

import java.util.HashMap;

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
     */
    public int doublePointer2(int[] arr) {
        var res = 0;
        var map = new HashMap<Integer, Integer>(); // 记录数字出现的次数
        for (int i = 0, j = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            while (j < i && map.get(arr[i]) > 1) {
                map.put(arr[j], map.get(arr[j]) - 1);
                j++;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
    
    /**
     * 匹配子序列
     */
    public void doublePointer3(int[] arr1, int[] arr2) {
        int m = arr1.length, n = arr2.length;
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (arr1[i] == arr2[j]) i++;
            j++;
        }
        if (i == m) System.out.println("Yes");
        else System.out.println("No");
    }
}
