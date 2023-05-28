package alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @link https://leetcode.cn/problems/remove-invalid-parentheses/
 * @author zhangxq
 * @since 2023/5/28
 */
public class P301RemoveInvalidParentheses {
    
    public static void main(String[] args) {
    
    }
    
    List<String> res = new ArrayList<>();
    public List<String> removeInvalidParentheses(String s) {
        // l 表示当前左括号数量 - 右括号数量；r 表示当前需要删除多少个右括号；
        int l = 0, r = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') l++;
            else if (c == ')') {
                if (l == 0) r++;
                else l--;
            }
        }
        dfs(s, 0, "", 0, l, r);
        return res;
    }
    
    public void dfs(String s, int u, String path, int cnt, int l, int r) {
        if (u == s.length()) {
            if (cnt == 0) res.add(path);
            return;
        }
        if (s.charAt(u) != '(' && s.charAt(u) != ')')
            dfs(s, u + 1, path + s.charAt(u), cnt, l, r);
        else if (s.charAt(u) == '(') {
            // 把邻近的左括号都删掉
            int k = u;
            while (k < s.length() && s.charAt(k) == '(') k++;
            l -= k - u;
            // 枚举要删除掉的左括号
            for (int i = k - u; i >= 0; i--) {
                if (l >= 0) dfs(s, k, path, cnt, l, r);
                path += "("; cnt++; l++;
            }
        }
        else if (s.charAt(u) == ')') {
            int k = u;
            while (k < s.length() && s.charAt(k) == ')') k++;
            r -= k - u;
            for (int i = k - u; i >= 0; i--) {
                if (cnt >= 0 && r >= 0) dfs(s, k, path, cnt, l, r);
                path += ")"; cnt--; r++;
            }
        }
    }
}
