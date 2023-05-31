package alg.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author zhangxq
 * @link https://leetcode.cn/problems/flatten-nested-list-iterator/
 * @since 2023/5/31
 */
public class P341FlattenNestedListIterator {
    
    public static void main(String[] args) {
    
    }
    
    static
    class NestedIterator implements Iterator<Integer> {
        List<Integer> q;
        int k;
        public NestedIterator(List<NestedInteger> nestedList) {
            q = new ArrayList<>();
            k = 0;
            for (var l : nestedList) dfs(l);
        }
        
        public void dfs(NestedInteger l) {
            if (l.isInteger()) {
                q.add(l.getInteger());
                return;
            }
            for (var x : l.getList()) dfs(x);
        }
        
        @Override
        public Integer next() {
            return q.get(k++);
        }
        
        @Override
        public boolean hasNext() {
            return k < q.size();
        }
    }
    
    interface NestedInteger {
        boolean isInteger();
        Integer getInteger();
        List<NestedInteger> getList();
    }
}
