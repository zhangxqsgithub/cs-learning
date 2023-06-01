package alg.leetcode;

import java.util.Arrays;

/**
 * @link https://leetcode.cn/problems/russian-doll-envelopes/
 * @author zhangxq
 * @since 2023/6/1
 */
public class P354RussianDollEnvelopes {
    
    public static void main(String[] args) {
    
    }
    
    // 从前往后遍历时，宽度一定是从小到大的，即使出现了宽度相等的情况，由于排序规则的设定，
    // 此时高度是降序的，也就是说会先判断高度最高的情况，如果高度最高的情况都加不进去，后面的
    // 也一定加不进去，如果高度最高的能加进去，后面的高度一定是 <= 当前的高度，所以也加不进去
    // （只有高度严格大于才可以加），实现了宽度相等只可能加一个的情况，所以正向遍历时，为每个
    // 高度设置一个最长上升子序列数组 q，q[i] 表示最长上升子序列长度为 i 时的结尾最小元素（
    // 宽度一定是满足的，只需要判断高度即可，所以转化为了，高度的最长上升子序列模型）
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        // 先按宽度升序排序，再按高度降序排序
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            else return b[1] - a[1];
        });
        int len = 0; // q 数组的有效长度
        // 高度的最长上升子序列数组，q[i] 表示最长上升子序列长度为 i 时的结尾最小元素
        int[] q = new int[n + 1];
        // 现存一个哨兵，保证第一个元素可以顺利接入
        q[0] = -0x3f3f3f3f;
        for (int i = 0; i < n; i++) {
            // 二分查找
            int l = 0, r = len;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (q[mid] < envelopes[i][1]) l = mid;
                else r = mid - 1;
            }
            q[r + 1] = envelopes[i][1];
            len = Math.max(len, r + 1);
        }
        return len;
    }
}
