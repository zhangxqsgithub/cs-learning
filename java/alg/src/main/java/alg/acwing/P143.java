package alg.acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @link https://www.acwing.com/problem/content/145/
 * @author will
 * @since 2024/5/6
 */
public class P143 {

    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(reader.readLine());
        var strs = reader.readLine().split(" ");
        var nums = new int[n];
        for(int i = 0; i < n; i++) {
            int temp = Integer.parseInt(strs[i]);
            nums[i] = temp;
        }
        var res = xorMax(nums);
        System.out.println(res);
    }

    public static int xorMax(int[] arr) {
        var res = 0;
        var trie = new Trie();
        for (int x : arr) trie.insert(x);
        for (int x : arr) {
            int xor = 0;
            var cur = trie;
            for (int i = 31; i >= 0; i--) {
                int b = x >> i & 1;
                int sb = b == 0 ? 1 : 0;
                if (cur.contain(sb)) {
                    xor += 1 << i;
                    cur = cur.get(sb);
                }
                else cur = cur.get(b);
            }
            res = Math.max(res, xor);
        }
        return res;
    }

    private static class Trie {
        Trie[] child;
        boolean isEnd;
        public Trie() {
            this.child = new Trie[2];
            this.isEnd = false;
        }
        public void insert(int x) {
            var cur = this;
            for (int i = 31; i >= 0; i--) {
                int num = x >> i & 1;
                if (!cur.contain(num)) cur.set(num);
                cur = cur.get(num);
            }
            cur.isEnd = true;
        }
        public Trie get(int num) {
            if (contain(num)) {
                return this.child[num];
            }
            else return null;
        }
        public void set(int num) {
            this.child[num] = new Trie();
        }
        private boolean contain(int num) {
            if (0 <= num && num < 2) {
                return this.child[num] != null;
            }
            else return false;
        }
    }
}
