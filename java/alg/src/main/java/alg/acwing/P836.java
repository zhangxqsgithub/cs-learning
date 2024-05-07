package alg.acwing;

import java.util.Scanner;

/**
 * @link https://www.acwing.com/problem/content/description/838/
 * @author will
 * @since 2024/5/6
 */
public class P836 {
    
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        int n = scan.nextInt(), m = scan.nextInt();
        var uf = new UnionFind(n);
        while (0 < m--) {
            var s = scan.next();
            int a = scan.nextInt(), b = scan.nextInt();
            // 合并集合
            if (s.equals("M")) uf.union(a, b);
            else if (s.equals("Q")) {
                System.out.println(uf.isConnect(a, b) ? "Yes" : "No");
            }
        }
    }
    
    private static class UnionFind {
        int count;
        int[] parent;
        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        public int find(int x) {
            while (x != parent[x]) x = find(parent[x]);
            return x;
        }
        public void union(int a, int b) {
            parent[find(a)] = find(b);
            count--;
        }
        public boolean isConnect(int a, int b) {
            return find(a) == find(b);
        }
        public int count() { return count; }
    }
}
