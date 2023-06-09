package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/battleships-in-a-board/
 * @author zhangxq
 * @since 2023/6/9
 */
public class P419BattleshipsInABoard {
    
    public static void main(String[] args) {
    
    }
    
    public int countBattleships(char[][] board) {
        int res = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i > 0 && board[i - 1][j] == 'X') continue;
                if (j > 0 && board[i][j - 1] == 'X') continue;
                if (board[i][j] == 'X') res++;
            }
        }
        return res;
    }
}
