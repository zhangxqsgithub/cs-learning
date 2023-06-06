package alg.leetcode;

import java.util.Stack;

/**
 * @link https://leetcode.cn/problems/longest-absolute-file-path/
 * @author zhangxq
 * @since 2023/6/6
 */
public class P388LongestAbsoluteFilePath {
    
    public static void main(String[] args) {
    
    }
    
    public int lengthLongestPath(String input) {
        Stack<Integer> stk = new Stack<>();
        int res = 0;
        for (int i = 0, sum = 0; i < input.length(); i++) {
            int k = 0;
            while (i < input.length() && input.charAt(i) == '\t') { i++; k++; }
            while (stk.size() > k) sum -= stk.pop();
            int j = i;
            while (j < input.length() && input.charAt(j) != '\n') j++;
            int len = j - i;
            stk.push(len); sum += len;
            if (input.substring(i, j).indexOf('.') != -1) res = Math.max(res, sum + stk.size() - 1);
            i = j;
        }
        return res;
    }
}
