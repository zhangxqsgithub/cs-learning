package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/nth-highest-salary/
 * @author zhangxq
 * @since 2023/5/8
 */
public class P177NthHighestSalary {
    
    public static void main(String[] args) {
        var s = """
                CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
                BEGIN
                    set N := N-1;
                    RETURN (
                        select (
                            select distinct salary
                            from Employee
                            order by salary desc
                            limit N, 1
                        ) as SecondHighestSalary
                    );
                END
                """;
    }
    
}
