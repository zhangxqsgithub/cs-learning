package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/convert-a-number-to-hexadecimal/
 * @author zhangxq
 * @since 2023/6/8
 */
public class P405ConvertANumberToHexadecimal {
    
    public static void main(String[] args) {
        var solution = new P405ConvertANumberToHexadecimal();
        var res = solution.toHex(0);
        System.out.println(res);
    }
    
    // 32 位数每组 4 位分成 8 组即可，求每组的数
    public String toHex(int num) {
        var hex = new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        var res = new StringBuilder();
        for (int i = 32; i > 0; i -= 4) {
            int x = num >>> i - 4 & 15;
            res.append(hex[x]);
        }
        // 去除前导 0
        int k = 0;
        while (k < res.length() && res.charAt(k) == '0') k++;
        if (k == res.length()) res.append('0');
        return res.substring(k + 1);
    }
}
