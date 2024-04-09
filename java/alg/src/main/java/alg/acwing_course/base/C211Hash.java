package alg.acwing_course.base;

/**
 * @author will
 * @since 2024/4/9
 */
public class C211Hash {
    
    // 字符串 hash
    public long strHash(String str) {
        int P = 13331;
        int n = str.length();
        var h = new long[n];
        var p = new long[n];
        p[0] = 1;
        for (int i = 1; i < n; i++) {
            h[i] = h[i - 1] * P + str.charAt(i);
            p[i] = p[i - 1] * P;
        }
        
        int l = 0, r = str.length() - 1;
        return h[r] - h[l - 1] * p[r - l + 1];
    }
}
