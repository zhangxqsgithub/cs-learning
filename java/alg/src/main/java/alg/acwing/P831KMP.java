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
        for (Integer idx : res) {
            System.out.print(idx + " ");
        }
    }
    
    // next 数组
    public static int[] next(String p) {
        var next = new int[p.length() + 1];
        for (int i = 2, j = 0; i <= p.length(); i++) {
            while (j != 0 && p.charAt(i) != p.charAt(j + 1)) j = next[j];
            if (p.charAt(i) == p.charAt(j + 1)) j++;
            next[i] = j;
        }
        return next;
    }
    
    public static List<Integer> kmp(String s, String p) {
        var res = new ArrayList<Integer>();
        var next = next(p);
        for (int i = 1, j = 0; i <= s.length(); i++) {
            while (j > 0 && s.charAt(i) != p.charAt(j + 1)) j = next[j];
            if (s.charAt(i) == p.charAt(j + 1)) j++;
            if (j == p.length()) {
                j = next[j];
                // 匹配成功
                res.add(i - p.length() + 1);
            }
        }
        return res;
    }
    
}
