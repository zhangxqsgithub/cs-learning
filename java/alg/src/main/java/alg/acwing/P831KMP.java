package alg.acwing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangxq
 * @since 2023/6/29
 */
public class P831KMP {
    
    public static void main(String[] args) throws Exception {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        var p = br.readLine();
        var m = Integer.parseInt(br.readLine());
        var s = br.readLine();
        
        var res = kmp(s, p);
        
        // 这里不要每一行都调用 sout，会超时！
        var sb = new StringBuilder();
        for (Integer idx : res) sb.append(idx).append(" ");
        System.out.println(sb);
    }
    
    // next 数组
    public static int[] next(String p) {
        var next = new int[p.length()];
        for (int i = 1, j = 0; i < p.length(); i++) {
            while (j > 0 && p.charAt(i) != p.charAt(j)) j = next[j - 1];
            if (p.charAt(i) == p.charAt(j)) j++;
            next[i] = j;
        }
        return next;
    }
    
    public static List<Integer> kmp(String s, String p) {
        var res = new ArrayList<Integer>();
        var next = next(p);
        for (int i = 0, j = 0; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != p.charAt(j)) j = next[j - 1];
            if (s.charAt(i) == p.charAt(j)) j++;
            if (j == p.length()) {
                j = next[j - 1];
                // 匹配成功
                res.add(i - p.length() + 1);
            }
        }
        return res;
    }
    
}
