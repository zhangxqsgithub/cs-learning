package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/utf-8-validation/
 * @author zhangxq
 * @since 2023/6/6
 */
public class P393Utf8Validation {
    
    public static void main(String[] args) {
        var solution = new P393Utf8Validation();
        var data = new int[]{250,145,145,145,145};
        var res = solution.validUtf8(data);
        System.out.println(res);
    }
    
    public boolean validUtf8(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int x = data[i];
            if (get(x, 7) == 0) continue;
            int len = 0; // 记录前面出现的 1 的个数
            for (int j = 7; j >= 0 && get(x, j) == 1; j--) len++;
            if (len == 1 || len > 4) return false;
            int k = len - 1;
            for (int j = i + 1; j < data.length && k > 0; j++) {
                if (get(data[j], 7) != 1 || get(data[j], 6) != 0) return false;
                k--;
            }
            if (k != 0) return false;
            i += len - 1;
        }
        return true;
    }
    public int get(int x, int idx) {
        return 1 & x >> idx;
    }
}
