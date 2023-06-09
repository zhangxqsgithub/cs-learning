package alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @link https://leetcode.cn/problems/fizz-buzz/
 * @author zhangxq
 * @since 2023/6/9
 */
public class P412FizzBuzz {
    
    public static void main(String[] args) {
    
    }
    
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String str = "";
            if (i % 3 == 0) str += "Fizz";
            if (i % 5 == 0) str += "Buzz";
            if (str.isEmpty()) str = String.valueOf(i);
            res.add(str);
        }
        return res;
    }
}
