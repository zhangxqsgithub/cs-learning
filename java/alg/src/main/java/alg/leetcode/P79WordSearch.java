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
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int i, int j, int k) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (board[i][j] == word.charAt(k)) {
            char tmp = board[i][j];
            board[i][j] = '*';
            if (k == word.length() - 1 || dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) || dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i, j - 1, k + 1)) {
                return true;
            }
            board[i][j] = tmp;
        }
        return false;
    }
    
}
