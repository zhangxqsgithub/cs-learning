package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/game-of-life/
 * @author zhangxq
 * @since 2023/5/26
 */
public class P289GameOfLife {
    
    public static void main(String[] args) {
    
    }
    
    /**
     * 用 int 二进制的第二位存下一阶段细胞是否存活的数据
     */
    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        int n = board.length, m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int live = 0;
                for (int x = Math.max(0, i - 1); x <= Math.min(n - 1, i + 1); x++)
                    for (int y = Math.max(0, j - 1); y <= Math.min(m - 1, j + 1); y++)
                        if ((x != i || y != j) && (board[x][y] & 1) == 1) live++;
                int cur = board[i][j] & 1, next = 0;
                if (cur == 1) {
                    if (live < 2 || live > 3) next = 0;
                    else next = 1;
                }
                else {
                    if (live == 3) next = 1;
                    else next = 0;
                }
                board[i][j] |= next << 1;
            }
        }
        
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                board[i][j] >>= 1;
    }
}
