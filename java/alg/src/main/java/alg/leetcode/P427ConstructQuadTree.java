package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/construct-quad-tree/
 * @author zhangxq
 * @since 2023/6/9
 */
public class P427ConstructQuadTree {
    
    public static void main(String[] args) {
    
    }
    
    /**
     * 使用二维前缀和的技巧判断某块举行是全 0 还是 全 1
     */
    int[][] sum;
    public Node construct(int[][] grid) {
        int n = grid.length;
        sum = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + grid[i - 1][j - 1];
        return dfs(1, 1, n, n);
    }
    public Node dfs(int x1, int y1, int x2, int y2) {
        int n = x2 - x1 + 1;
        int s = sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];
        if (s == 0 || s == n * n) return new Node(s != 0, true);
        
        int mid = n / 2;
        var node = new Node(false, false);
        node.topLeft = dfs(x1, y1, x1 + mid - 1, y1 + mid - 1);
        node.topRight = dfs(x1, y1 + mid, x1 + mid - 1, y2);
        node.bottomLeft = dfs(x1 + mid, y1, x2, y1 + mid - 1);
        node.bottomRight = dfs(x1 + mid, y1 + mid, x2, y2);
        return node;
    }
    
    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;
        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }
        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }
        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
}
