package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/combine-two-tables/
 * @author zhangxq
 * @since 2023/5/8
 */
public class P175CombineTwoTables {
    
    public static void main(String[] args) {
        var s = """
                select
                    p.lastName,
                    p.firstName,
                    a.city,
                    a.state
                from Person p
                    left join Address a on p.personId = a.personId
                """;
    }
    
    
}
