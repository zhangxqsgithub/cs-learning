package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/excel-sheet-column-number/
 * @author zhangxq
 * @since 2023/5/7
 */
public class P171ExcelSheetColumnNumber {
    
    public static void main(String[] args) {
    
    }
    
    public int titleToNumber(String s) {
        var a = 0;
        for (int i = 0, p = 26; i < s.length() - 1; i++, p *= 26) {
            a += p;
        }
        // 秦九韶 算法
        int b = 0;
        for (var c : s.toCharArray()) b = b * 26 + c - 'A';
        return a + b + 1;
    }
}
