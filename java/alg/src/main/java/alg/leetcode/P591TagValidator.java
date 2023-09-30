package alg.leetcode;

import java.util.Stack;

/**
 * @link https://leetcode.cn/problems/tag-validator/
 * @author zhangxq
 * @since 2023/9/29
 */
public class P591TagValidator {
    
    public static void main(String[] args) {
        var solution = new P591TagValidator();
        var res1 = solution.isValid("<A><!A></A>");
        System.out.println(res1);
    }
    
    public boolean isValid(String code) {
        var stk = new Stack<String>();
        for (int i = 0; i < code.length(); i++) {
            if (code.charAt(i) == '<') {
                // 若 < 下面没有字符了
                if (i + 1 == code.length()) return false;
                if ('A' <= code.charAt(i + 1) && code.charAt(i + 1) <= 'Z') { // 标签
                    int j = i + 1;
                    while (j < code.length() && code.charAt(j) != '>') {
                        var c = code.charAt(j);
                        if (c < 'A' || c > 'Z') return false; // 不是大写字母
                        j++;
                    }
                    if (j == code.length()) return false; // 标签没有以 > 结尾
                    var tagName = code.substring(i + 1, j);
                    if (tagName.length() < 1 || tagName.length() > 9) return false; // 标签名长度不在 1～9 之间
                    if (i > 0 && stk.isEmpty()) return false; // 若不是第一个标签，并且标签数为 0
                    stk.push(tagName);
                    i = j;
                }
                else if (code.charAt(i + 1) == '/') { // 结束标签
                    int j = i + 2;
                    while (j < code.length() && code.charAt(j) != '>') {
                        var c = code.charAt(j);
                        if (c < 'A' || c > 'Z') return false; // 不是大写字母
                        j++;
                    }
                    if (j == code.length()) return false;
                    var tagName = code.substring(i + 2, j);
                    if (tagName.length() < 1 || tagName.length() > 9) return false; // 标签名长度不在 1～9 之间
                    if (stk.isEmpty() || !tagName.equals(stk.peek())) return false; // 结束标签未匹配
                    stk.pop();
                    i = j;
                }
                else if (code.charAt(i + 1) == '!' && i + 9 < code.length() && "<![CDATA[".equals(code.substring(i, i + 9))) { // CDATA 标签
                    if (stk.isEmpty()) return false; // 若 tag-content 不在标签里
                    int j = i + 9;
                    while (j + 3 < code.length() && !"]]>".equals(code.substring(j, j + 3))) j++;
                    if (j + 3 == code.length()) return false; // CDATA 没有结尾
                    i = j + 2;
                }
                else return false; // 错误的标签
            }
            else {
                if (stk.isEmpty()) return false; // 若 tag-content 不在标签里
            }
        }
        return stk.isEmpty();
    }
    
}
