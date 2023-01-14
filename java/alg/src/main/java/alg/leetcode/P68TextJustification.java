package alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 文本左右对齐
 *
 * @author zhangxq
 * @link https://leetcode.cn/problems/text-justification/
 * @since 2023/1/14
 */
public class P68TextJustification {
    
    public static void main(String[] args) {
    
    }
    
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            int j = i + 1;
            int len = words[i].length();
            while (j < words.length && len + 1 + words[j].length() <= maxWidth) {
                len += 1 + words[j++].length();
            }
            String line = "";
            if (j == words.length || j == i + 1) { // 左对齐
                line += words[i];
                for (int k = i + 1; k < j; k++) line += ' ' + words[k];
                while (line.length() < maxWidth) line += ' ';
            }
            else { // 左右对齐
                int cnt = j - i - 1, r = maxWidth - len + cnt;
                line += words[i];
                int k = 0;
                while (k < r % cnt) {
                    line += " ".repeat(r / cnt + 1) + words[i + k + 1];
                    k++;
                }
                while (k < cnt) {
                    line += " ".repeat(r / cnt) + words[i + k + 1];
                    k++;
                }
            }
            res.add(line);
            i = j - 1;
        }
        return res;
    }
}
