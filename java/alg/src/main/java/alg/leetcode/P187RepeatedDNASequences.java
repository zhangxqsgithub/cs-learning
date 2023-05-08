package alg.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @link https://leetcode.cn/problems/repeated-dna-sequences/
 * @author zhangxq
 * @since 2023/5/8
 */
public class P187RepeatedDNASequences {
    
    public static void main(String[] args) {
    
    }
    
    public List<String> findRepeatedDnaSequences(String s) {
        var cnt = new HashMap<String, Integer>();
        for (var i = 0; i + 10 <= s.length(); i++) {
            String k = s.substring(i, i + 10);
            cnt.put(k, cnt.getOrDefault(k, 0) + 1);
        }
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            if (entry.getValue() > 1) res.add(entry.getKey());
        }
        return res;
    }
}
