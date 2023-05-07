package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/excel-sheet-column-title/
 * @author zhangxq
 * @since 2023/5/7
 */
public class P168ExcelSheetColumnTitle {
    
    public static void main(String[] args) {
    
    }
    
    public String convertToTitle(int n) {
        var k = 1;
        for (long p = 26; n > p; p *= 26) {
            n -= p;
            k++;
        }
        
        n--;
        var res = new StringBuilder();
        while (0 < k--) {
            res.append((char) (n % 26 + 'A'));
            n /= 26;
        }
        return res.reverse().toString();
    }
    
}
