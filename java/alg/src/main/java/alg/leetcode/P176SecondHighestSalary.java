package alg.leetcode;

/**
 * @link https://leetcode.cn/problems/second-highest-salary/
 * @author zhangxq
 * @since 2023/5/8
 */
public class P176SecondHighestSalary {
    
    public static void main(String[] args) {
        var s = """
                select (
                            select distinct salary
                            from Employee
                            order by salary desc
                            limit 1, 1
                        ) as SecondHighestSalary
                """;
    }
}
