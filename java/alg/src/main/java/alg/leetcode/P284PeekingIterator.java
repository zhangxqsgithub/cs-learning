package alg.leetcode;

import java.util.Iterator;

/**
 * @link https://leetcode.cn/problems/peeking-iterator/
 * @author zhangxq
 * @since 2023/5/26
 */
public class P284PeekingIterator {
    
    static
    class PeekingIterator implements Iterator<Integer> {
        Iterator<Integer> it;
        int cur;
        boolean hasNext;
        public PeekingIterator(Iterator<Integer> iterator) {
            this.it = iterator;
            this.hasNext = it.hasNext();
            if (this.hasNext) cur = it.next();
        }
        
        public Integer peek() {
            return cur;
        }
        
        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            int t = cur;
            this.hasNext = it.hasNext();
            if (this.hasNext) cur = it.next();
            return t;
        }
        
        @Override
        public boolean hasNext() {
            return hasNext;
        }
    }
}
