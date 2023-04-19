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
        P89GrayCode solution = new P89GrayCode();
        List<Integer> res1 = solution.grayCode2(3);
        System.out.println(res1);
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
    
    /**
     * 异或生成
     */
    public List<Integer> grayCode2(int n) {
        int count = 1 << n;
        List<Integer> res = new ArrayList<>(count);
        for (int i = 0; i < count; i++) res.add(0);
        for (int i = 1; i < count; i++) {
            int cur = i >> (n - 1);
            for (int k = n - 1; k > 0; k--)
                cur = (cur << 1) + (((i >> k) & 1) ^ ((i >> (k - 1)) & 1));
            res.set(i, cur);
        }
        return res;
    }
    
    public List<Integer> grayCode3(int n) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) ret.add((i >> 1) ^ i);
        return ret;
    }
    
    /**
     * dfs 实现
     */
    public List<Integer> grayCode4(int n) {
        List<Integer> ans = new ArrayList<>(1 << n);
        dfs(ans, 0, 0, n);
        return ans;
    }
    
    private int dfs(List<Integer> res, int code, int i, int n) {
        if (i == n) {
            res.add(code);
            return code;
        }
        code = dfs(res, code, i + 1, n);
        return dfs(res, code ^ (1 << (n - 1 - i)), i + 1, n);
    }
}
