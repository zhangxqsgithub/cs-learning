package alg.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @link https://leetcode.cn/problems/h-index/
 * @author zhangxq
 * @since 2023/5/25
 */
public class P274HIndex {
    
    public static void main(String[] args) {
    
    }
    
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            if (i + 1 > citations[n - i - 1])
                return i;
        }
        return n;
    }

}
