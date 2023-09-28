package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/number-of-provinces/
 * @author zhangxq
 * @since 2023/9/28
 */
public class P547NumberOfProvinces {
    
    public static void main(String[] args) {
    
    }
    
    int[] p;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        p = new int[n];
        for (int i = 0; i < n; i++) p[i] = i;
        
        int cnt = n;
        // 枚举所有省份的边
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 若两个有边，并且 i 和 j 不在同一个集合里
                if (isConnected[i][j] == 1 && find(i) != find(j)) {
                    // 合并集合
                    p[find(i)] = find(j);
                    cnt--;
                }
            }
        }
        return cnt;
    }
    // 并查集
    private int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }
}
