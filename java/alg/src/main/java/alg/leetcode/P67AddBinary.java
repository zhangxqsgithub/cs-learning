package alg.leetcode;


/**
 * 二进制求和
 *
 * @author zhangxq
 * @link https://leetcode.cn/problems/add-binary/
 * @since 2023/1/14
 */
public class P67AddBinary {
    
    public static void main(String[] args) {
        P67AddBinary solution = new P67AddBinary();
        String res = solution.addBinary("1011", "0010");
        System.out.println(res);
    }
    
    public String addBinary(String a, String b) {
        a = reverse(a);
        b = reverse(b);
        StringBuilder c = new StringBuilder();
        for (int i = 0, t = 0; i < a.length() || i < b.length() || t != 0; i++) {
            if (i < a.length()) t += a.charAt(i) - '0';
            if (i < b.length()) t += b.charAt(i) - '0';
            c.append(t % 2);
            t /= 2;
        }
        return reverse(c.toString());
    }
    
    private String reverse(String str) {
        char[] a = str.toCharArray();
        int l = 0, r = a.length - 1;
        while (l < r) {
            char t = a[l];
            a[l] = a[r];
            a[r] = t;
            l++;
            r--;
        }
        return String.copyValueOf(a);
    }
    
}
