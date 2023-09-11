package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/magical-string/
 * @author zhangxq
 * @since 2023/9/11
 */
public class P481MagicalString {
    
    public static void main(String[] args) {
        var solution = new P481MagicalString();
        var res1 = solution.magicalString(6);
        System.out.println(res1);
    }
    
    public int magicalString(int n) {
        var ms = new StringBuilder("122");
        int idx = 2, s = 1, cnt = 1;
        while (ms.length() < n) {
            var r = ms.charAt(idx) - '0';
            ms.append(String.valueOf(s).repeat(r));
            if (s == 1) s = 2;
            else s = 1;
            idx++;
        }
        for (int i = 0; i < n; i++)
            if (ms.charAt(i) == '1')
                cnt++;
        return cnt;
    }
}
