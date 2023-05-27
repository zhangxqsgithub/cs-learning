package alg.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;

/**
 * @link https://leetcode.cn/problems/find-median-from-data-stream/
 * @author zhangxq
 * @since 2023/5/27
 */
public class P295FindMedianFromDataStream {
    
    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(6);
        mf.addNum(10);
        mf.addNum(2);
        mf.addNum(6);
        System.out.println(mf.down);
        System.out.println(mf.up);
        System.out.println(mf.findMedian());
        
        mf.addNum(5);
        System.out.println(mf.down);
        System.out.println(mf.up);
        System.out.println(mf.findMedian());
        
    }
    
    /**
     * 对顶堆 数据结构
     * 左边大顶堆，右边小顶堆；
     */
    static
    class MedianFinder {
        Queue<Integer> down;
        Queue<Integer> up;
        public MedianFinder() {
            down = new PriorityQueue<>(Comparator.reverseOrder());
            up = new PriorityQueue<>();
        }
        
        public void addNum(int num) {
            if (down.isEmpty() || num <= down.peek()) {
                down.add(num);
                if (down.size() > up.size() + 1) up.add(down.poll());
            }
            else {
                up.add(num);
                if (down.size() < up.size()) down.add(up.poll());
            }
        }
        
        public double findMedian() {
            if ((down.size() + up.size()) % 2 == 0)
                return (down.peek() + up.peek()) / 2D;
            else
                return down.peek();
        }
    }
}
