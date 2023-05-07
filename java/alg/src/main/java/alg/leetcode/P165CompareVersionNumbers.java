package alg.leetcode;

import java.util.Arrays;

/**
 * @link https://leetcode.cn/problems/compare-version-numbers/
 * @author zhangxq
 * @since 2023/5/7
 */
public class P165CompareVersionNumbers {
    
    public static void main(String[] args) {
    }
    
    public int compareVersion(String version1, String version2) {
        var v1 = version1.split("\\.");
        var v2 = version2.split("\\.");
        for (int i = 0, j = 0; i < v1.length || j < v2.length; i++, j++) {
            var a = Integer.parseInt(i < v1.length ? v1[i] : "0");
            var b = Integer.parseInt(j < v2.length ? v2[j] : "0");
            if (a < b) return -1;
            else if (a > b) return 1;
        }
        return 0;
    }
    
    public int compareVersion2(String version1, String version2) {
        int m = version1.length(), n = version2.length();
        int i = 0, j = 0;
        while (i < m || j < n) {
            int x = 0, y = 0;
            while (i < m && version1.charAt(i) != '.') {
                x = 10 * x + version1.charAt(i) - '0'; i++;
            }
            i++;
            while (j < n && version2.charAt(j) != '.') {
                y = 10 * y + version2.charAt(j) - '0'; j++;
            }
            j++;
            if (x > y) return 1;
            else if (x < y) return -1;
        }
        return 0;
    }
}
