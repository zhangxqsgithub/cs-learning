package alg.leetcode;

import java.util.*;

/**
 * @link https://leetcode.cn/problems/insert-delete-getrandom-o1-duplicates-allowed/
 * @author zhangxq
 * @since 2023/6/5
 */
public class P381InsertDeleteGetrandomO1DuplicatesAllowed {
    
    public static void main(String[] args) {
        var solution = new RandomizedCollection();
        solution.insert(4);
        solution.insert(4);
        solution.insert(4);
        solution.remove(4);
        solution.remove(4);
        var res = solution.remove(4);
        System.out.println(res);
    }
    
    static
    class RandomizedCollection {
        List<Integer> list;
        Map<Integer, Set<Integer>> map;
        public RandomizedCollection() {
            list = new ArrayList<>();
            map = new HashMap<>();
        }
        public boolean insert(int val) {
            if (map.containsKey(val) && !map.get(val).isEmpty()) {
                var l = map.get(val);
                list.add(val);
                l.add(list.size() - 1);
                return false;
            }
            else {
                var l = new HashSet<Integer>();
                list.add(val);
                l.add(list.size() - 1);
                map.put(val, l);
                return true;
            }
        }
        public boolean remove(int a) {
            if (map.containsKey(a) && !map.get(a).isEmpty()) {
                var as = map.get(a);
                var ai = as.iterator().next();
                var bi = list.size() - 1;
                var b = list.get(bi);
                var bs = map.get(b);
                if (a == b) {
                    as.remove(list.size() - 1);
                    list.remove(list.size() - 1);
                    return true;
                }
                
                list.set(ai, b);
                list.set(bi, a);
                as.remove(ai);
                bs.remove(bi);
                bs.add(ai);
                list.remove(bi);
                return true;
            }
            else return false;
        }
        public int getRandom() {
            Random random = new Random();
            int idx = random.nextInt(0, list.size());
            return list.get(idx);
        }
    }
}
