package alg.struct;

/**
 * @author zhangxq
 * @since 2023/6/29
 */
public class ArrayTrie3 {
    
    public static void main(String[] args) {
        var t = new Trie();
        t.insert("a");
        t.insert("aa");
        t.insert("aab");
        t.insert("aabb");
        t.insert("aac");
        System.out.println(t);
    }
    
    static class Trie {
        TrieNode root;
        public Trie() {
            this.root = new TrieNode();
        }
        public void insert(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!cur.contain(c)) cur.set(c);
                cur = cur.get(c);
            }
            cur.setEnd(true);
        }
        public boolean startsWith(String prefix) {
            return searchTrieNode(prefix) != null;
        }
        public boolean search(String word) {
            TrieNode node = searchTrieNode(word);
            return node != null && node.isEnd();
        }
        private TrieNode searchTrieNode(String word) {
            var cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!cur.contain(c)) return null;
                cur = cur.get(c);
            }
            return cur;
        }
    }

    static class TrieNode {
        TrieNode[] child;
        boolean end;
        public TrieNode() {
            this.child = new TrieNode[26];
            this.end = false;
        }
        public boolean contain(char c) {
            int idx = c - 'a';
            return child[idx] != null;
        }
        public TrieNode get(char c) {
            int idx = c - 'a';
            return child[idx];
        }
        public void set(char c) {
            int idx = c - 'a';
            child[idx] = new TrieNode();
        }
        public boolean isEnd() {
            return end;
        }
        public void setEnd(boolean end) {
            this.end = end;
        }
    }
}
