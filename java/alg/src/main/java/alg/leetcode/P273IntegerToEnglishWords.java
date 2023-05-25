package alg.leetcode;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @link https://leetcode.cn/problems/integer-to-english-words/
 * @author zhangxq
 * @since 2023/5/25
 */
public class P273IntegerToEnglishWords {
    
    public static void main(String[] args) {
    
    }
    
    List<String> num0_19 = Stream.of("Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen").collect(Collectors.toList());
    List<String> num20_90 = Stream.of("Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety").collect(Collectors.toList());
    List<String> num1000 = Stream.of("Billion ", "Million ", "Thousand ", "").collect(Collectors.toList());
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        String res = "";
        for (int i = 1_000_000_000, j = 0; i >= 1; i /= 1000, j++) {
            if (num >= i) {
                res += get(num / i) + num1000.get(j);
                num %= i;
            }
        }
        return res.trim();
    }
    
    // 返回 1 ~ 999 的英文表示
    public String get(int x) {
        String res = "";
        if (x >= 100) {
            res += num0_19.get(x / 100) + " Hundred ";
            x %= 100;
        }
        if (x >= 20) {
            res += num20_90.get(x / 10 - 2) + " ";
            x %= 10;
        }
        if (x != 0) res += num0_19.get(x) + " ";
        return res;
    }
}
