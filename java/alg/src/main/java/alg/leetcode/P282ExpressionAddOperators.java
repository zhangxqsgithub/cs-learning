package alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangxq
 * @link https://leetcode.cn/problems/expression-add-operators/
 * @since 2023/5/26
 */
public class P282ExpressionAddOperators {
    
    public static void main(String[] args) {
    }
    
    List<String> res = new ArrayList<>();
    char[] path = new char[100];
    int n;
    int target;
    public List<String> addOperators(String num, int target) {
        this.n = num.length();
        this.target = target;
        dfs(num, 0, 0, 0, 1);
        return res;
    }
    
    /**
     * 如何将表达式求值的问题压缩成数量级别？
     * 可以将所有表达式的计算转化成 a + b * _，_ 是一个表达式，
     *               遇到 + 可以转化成 (a + b * c) + 1 * _, 其中 a' = (a + b * c), b' = 1;
     * 下一个数   =>   遇到 - 可以转化成 (a + b * c) + -1 * _, 其中 a' = (a + b * c), b' = -1;
     *               遇到 * 可以转化成 a + (b * c) * _, 其中 a' = a, b' = (b * c);
     * 开始时 a = 0, b = 1
     */
    public void dfs(String num, int idx, int len, long a, long b) {
        if (idx == n) {
            if (a == target) res.add(new String(path, 0, len - 1));
            return;
        }
        
        long c = 0;
        for (int i = idx; i < n; i++) {
            c = c * 10 + (num.charAt(i) - '0');
            path[len++] = num.charAt(i);
            
            // 遍历到最后一个数字时 后面额外附上一个加号 这样下一次搜索时的a就是表达式的值
            path[len] = '+';
            dfs(num, i + 1, len + 1, a + b * c, 1);
            // 判断是否最后一位
            if (i + 1 < n) {
                path[len] = '-';
                dfs(num, i + 1, len + 1, a + b * c, -1);
                path[len] = '*';
                dfs(num, i + 1, len + 1, a, b * c);
            }
            // 0 需要结束掉
            if (num.charAt(idx) == '0') break;
        }
    }
    
}
