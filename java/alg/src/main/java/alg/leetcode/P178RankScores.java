package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/rank-scores/
 * @author zhangxq
 * @since 2023/5/8
 */
public class P178RankScores {
    
    public static void main(String[] args) {
        var s = """
                select
                    score,
                    (
                        select count(DISTINCT score)
                        from scores
                        where score >= s.score
                    ) as rank
                from Scores s
                order by score desc
                """;
    }
}
