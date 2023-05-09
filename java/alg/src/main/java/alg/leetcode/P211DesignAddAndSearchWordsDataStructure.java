package alg.leetcode;

/**
 * @author zhangxq
 * @link https://leetcode.cn/problems/design-add-and-search-words-data-structure/
 * @since 2023/5/9
 */
public class P211DesignAddAndSearchWordsDataStructure {
    
    public static void main(String[] args) {
    
    }
    
    static
    class WordDictionary {
        Trie root;
        
        public WordDictionary() {
            root = new Trie();
        }
        
        public void addWord(String word) {
            var p = root;
            for (var c : word.toCharArray()) {
                int u = c - 'a';
                if (p.children[u] == null) p.children[u] = new Trie();
                p = p.children[u];
            }
            p.isEnd = true; // 这个单词有单词结尾的
        }
        
        public boolean search(String word) {
            return dfs(root, word, 0);
        }
        
        private boolean dfs(Trie p, String word, int i) {
            if (i == word.length()) return p.isEnd;
            if (word.charAt(i) != '.') {
                int u = word.charAt(i) - 'a';
                if (p.children[u] == null) return false;
                return dfs(p.children[u], word, i + 1);
            }
            else
                for (var j = 0; j < 26; j++)
                    if (p.children[j] != null && dfs(p.children[j], word, i + 1))
                        return true;
            return false;
        }
    }
    
    static class Trie {
        boolean isEnd;
        Trie[] children;
        
        Trie() {
            isEnd = false;
            children = new Trie[26];
        }
    }
}
