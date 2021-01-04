package exam;

import java.util.LinkedHashMap;
import java.util.Map;

//https://leetcode.com/problems/lru-cache/
//Complete
public class LRUCache {

    public static void main(String[] args) {

//        ["LRUCache","get","put","get","put","put","get","get"]
//              [[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
        LRUCache lruCache = new LRUCache(2);
        System.out.println(lruCache.get(2));
        lruCache.put(2, 6);
        lruCache.get(1);
        lruCache.put(1,5);
        lruCache.put(1,2);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));

    }

    LinkedHashMap<Integer, Integer> map;
    int capacity ;

    public LRUCache(int capacity) {
        this.map = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            Integer remove = map.remove(key);
            map.put(key, remove);
            return remove;

        } else return -1;
    }


    public void put(int key, int value) {
        if(map.containsKey(key)) {
            map.remove(key);
            map.put(key, value);
        }
        else if(map.size() < capacity) {
            map.put(key, value);
        } else {
            Map.Entry<Integer, Integer> next = map.entrySet().iterator().next();
            map.remove(next.getKey());
            map.put(key, value);
        }
    }
}
