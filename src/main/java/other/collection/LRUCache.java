package other.collection;

import java.util.LinkedHashMap;

class LRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(4));
        System.out.println(cache.get(3));
    }

    private LinkedHashMap<Integer, Integer> cache;

    private int size;

    public LRUCache(int capacity) {
        this.cache = new LinkedHashMap();
        this.size = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Integer value = cache.get(key);
        cache.remove(key);
        cache.put(key, value);
        return value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.remove(key);
            cache.put(key, value);
            return;
        }
        cache.put(key, value);
        if (cache.size() > this.size) {
            cache.remove(cache.entrySet().iterator().next().getKey());
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */