package alg.acwing;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @link https://www.acwing.com/problem/content/description/801/
 * @author will
 * @since 2024/3/28
 */
public class P799 {
    
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = scanner.nextInt();
        var arr = new int[n];
        // 标记重复数组
        var s = new int[100_010];
        for (int i = 0; i < n; i++) arr[i] = scanner.nextInt();
        var res = doublePointer(arr, s);
        System.out.print(res);
    }
    
    public static int doublePointer(int[] arr, int[] s) {
        int res = 0;
        for (int i = 0, j = 0; i < arr.length; i++) {
            s[arr[i]]++;
            // 此时只有 arr[i] 数字才有可能重复，所以需要 j 指针往前走一直走到 arr[i] 这个数字不重复为止。
            while (j < i && s[arr[i]] > 1) {
                s[arr[j]]--;
                j++;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
    
    /**
     * 使用 Map 方式去重
     */
    public static int doublePointer2(int[] arr) {
        var map = new HashMap<Integer, Integer>();
        var res = 0;
        for (int i = 0, j = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            while (j < i && map.containsKey(arr[i]) && map.get(arr[i]) > 1) {
                map.put(arr[j], map.get(arr[j]) - 1);
                j++;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
