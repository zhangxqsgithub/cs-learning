package alg.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @link https://leetcode.cn/problems/count-the-repetitions/
 * @author zhangxq
 * @since 2023/6/15
 */
public class P466CountTheRepetitions {
    
    public static void main(String[] args) {
    
    }
    
    // 查看循环节的最大长度是多少
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        var cnt = new ArrayList<Integer>();
        var map = new HashMap<Integer, Integer>();
        for (int i = 0, k = 0; i < n1; i++) {
            for (int j = 0; j < s1.length(); j++)
                if (s1.charAt(j) == s2.charAt(k % s2.length()))
                    k++;
            cnt.add(k);
            if (map.containsKey(k % s2.length())) { // 出现循环节
                int a = i - map.get(k % s2.length()); // 循环节中有多少个 s1
                int b = k - cnt.get(map.get(k % s2.length())); // 匹配了多少个 s2 中的字符
                int res = (n1 - i - 1) / a * b; // 还剩下多少个循环节
                for (int u = 0; u < (n1 - i - 1) % a; u++)
                    for (int j = 0; j < s1.length(); j++)
                        if (s1.charAt(j) == s2.charAt(k % s2.length()))
                            k++;
                res += k;
                return res / s2.length() / n2;
            }
            map.put(k % s2.length(), i);
        }
        if (cnt.isEmpty()) return 0;
        return cnt.get(cnt.size() - 1) / s2.length() / n2;
    }
    
}
