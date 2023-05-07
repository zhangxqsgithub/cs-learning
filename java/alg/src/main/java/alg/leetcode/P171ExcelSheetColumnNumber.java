package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/excel-sheet-column-number/
 * @author zhangxq
 * @since 2023/5/7
 */
public class P171ExcelSheetColumnNumber {
    
    public static void main(String[] args) {
    
    }

    // 本质上就是 26 进制的数
    public int titleToNumber(String s) {
        var res = 0;
        for (var c : s.toCharArray())
            res = res * 26 + c - 'A' + 1;
        return res;
    }
}
