package alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 插入区间
 *
 * @author zhangxq
 * @link https://leetcode.cn/problems/insert-interval/
 * @since 2023/1/11
 */
public class P57InsertInterval {
    
    public int[][] insert(int[][] a, int[] b) {
        List<int[]> list = new ArrayList<>();
        int l = b[0], r = b[1];
        int n = a.length, k = 0;
        while (k < n && a[k][1] < l) list.add(a[k++]); // 左边完全无交集的部分
        if (k < n) {
            l = Math.min(l, a[k][0]);
            while (k < n && a[k][0] <= r) r = Math.max(r, a[k++][1]); // 中间有交集的部分
        }
        list.add(new int[]{l, r});
        while (k < n) list.add(a[k++]);               // 右侧无交集的部分
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    
}
