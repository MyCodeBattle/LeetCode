/*
 * 一般的写法是用一个map + 双向链表，维护链表的最后一个结点。
 * LinkedHashMap是非常适合这个题目的，只要重载一下removeEldestEntry这个函数即可。
 * 然而有些人说这是作弊。
 * 那些人有本事手写map我也没话说。
 */

import java.util.LinkedHashMap;

public class LRUCache {
    private Map<Integer, Integer> map;
    
    public LRUCache(int capacity) {
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }
    
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }
    
    public void set(int key, int value) {
        map.put(key, value);
    }
}

