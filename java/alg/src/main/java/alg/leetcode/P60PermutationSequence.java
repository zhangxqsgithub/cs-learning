package alg.leetcode;

/**
 * 排列序列
 *
 * @author zhangxq
 * @link https://leetcode.cn/problems/permutation-sequence/
 * @since 2023/1/11
 */
public class P60PermutationSequence {
    
    public static void main(String[] args) {
    
    }
    
    public String getPermutation(int n, int k) {
        StringBuilder res = new StringBuilder();
        boolean[] v = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            // 求 (n - i) 的阶乘
            int fact = 1;
            for (int j = 1; j <= n - i - 1; j++) fact *= j;
            // 枚举没有被用过的数
            for (int j = 1; j <= n; j++) {
                if (!v[j]) {
                    if (fact < k) k -= fact;
                    else {
                        res.append(j);
                        v[j] = true;
                        break;
                    }
                }
            }
        }
        return res.toString();
    }
}
