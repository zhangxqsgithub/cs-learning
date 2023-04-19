package alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangxq
 * @link https://leetcode.cn/problems/gray-code/
 * @since 2023/4/19
 */
public class P89GrayCode {
    
    public static void main(String[] args) {
    
    }
    
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        int t = 1, size = 1;
        for (int k = 0; k < n; k++) {
            List<Integer> cur = new ArrayList<>();
            for (int i = 0; i < size; i++) cur.add(res.get(i));
            // 倒序地将每一个数都加上 t
            for (int i = size - 1; i >= 0; i--) cur.add(res.get(i) + t);
            res = cur;
            size = res.size();
            t = t << 1;
        }
        return res;
    }
}
