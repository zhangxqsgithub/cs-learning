package alg.leetcode;

/**
 * 单词搜索
 *
 * @author zhangxq
 * @link https://leetcode.cn/problems/word-search/
 * @since 2023/1/15
 */
public class P79WordSearch {
    
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (dfs(board, word, i, j, 0))
                    return true;
        return false;
    }
    
    /**
     * @param k 记录搜索到第几步了
     * @return
     */
    private boolean dfs(char[][] board, String word, int x, int y, int k) {
        if (word.charAt(k) != board[x][y]) return false;
        if (k == word.length() - 1) return true;
        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
        char t = board[x][y];
        board[x][y] = '*';
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i], b = y + dy[i];
            if (a >= 0 && a < board.length && b >= 0 && b < board[a].length) {
                if (dfs(board, word, a, b, k + 1)) return true;
            }
        }
        board[x][y] = t;
        return false;
    }
    
}
