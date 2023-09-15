package alg;

/**
 * @author zhangxq
 * @since 2023/9/15
 */
public class IterationAndRecursive {
    
    public static void main(String[] args) {
        var solution = new IterationAndRecursive();
        solution.it(new int[]{1, 2, 3, 4});
        solution.rec(new int[]{1, 2, 3, 4});
    }
    // 迭代
    public void it(int[] arr) {
        if (arr == null || arr.length == 0) return;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println();
    }
    // 递归
    public void rec(int[] arr) {
        rec(arr, 0);
        System.out.println();
    }
    private void rec(int[] arr, int idx) {
        if (idx == arr.length) return;
        System.out.print(arr[idx] + ",");
        rec(arr, idx + 1);
    }
}
