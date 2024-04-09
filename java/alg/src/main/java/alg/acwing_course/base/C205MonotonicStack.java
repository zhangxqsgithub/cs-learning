package alg.acwing_course.base;

import java.util.Scanner;
import java.util.Stack;

/**
 * 单调栈
 * @author will
 * @since 2024/4/9
 */
public class C205MonotonicStack {
    
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        var res = mono(arr);
        for (int i = 0; i < n; i++) System.out.print(res[i] + " ");
    }
    
    /**
     * 给定一个序列，求每一个数离它最近的且比它小的数在哪个位置。
     * 【1， 100， 2， 1， 5】
     *
     * 对于数组中任意连续的两个数字，若 a1 >= a2，a1 和 a2 所对应的前面最近比它小的数已经求
     * 出来了，那么求 a3 前面最近比它小的数有两种情况，
     * （1） 若 a3 > a2，则 a3 的前面最近比它小的数是 a2；
     * （2） 若 a3 <= a2，因 a2 <= a1，所以 a3 <= a1，因此 a1 不可能是 a3 的答案；
     * 所以这里的 a1 是任何情况下都不是 a3 的答案。
     * 以上这种推理，若 a1 是多个 >= a2 的数字也成立。
     * 所以，对于数组中任意不连续的连个数字，若 ai >= aj 则 ai 是一个可以被删掉的数字。
     *
     * 当我们将前面大于后面的数字删掉之后，就可以利用一个单调上升的栈来求解。
     * 若 stk[i] > stk[i - 1] 成立，则 stk[i] 对应的答案是 stk[i - 1]
     * 若 stk[i] <= stk[i - 1]，则将 stk 栈中值 pop 出来一直找到一个值使得
     * stk[i] > stk[i - x] 则 stk[i] 对应的答案就是 stk[i - x]。
     */
    public static int[] mono(int[] arr) {
        var stk = new Stack<Integer>();
        var res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            // 将栈中所有 >= arr[i] 的值都移除
            if (!stk.isEmpty() && stk.peek() >= arr[i]) {
                while (!stk.isEmpty() && stk.peek() >= arr[i]) stk.pop();
            }
            res[i] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(arr[i]);
        }
        return res;
    }
    
}
