package leetcode其他题目;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRU  {
    private int capacity;
    private LRULinkedHashMap<Integer, Integer> lruLinkedHashMap = new LRULinkedHashMap<>();

    class LRULinkedHashMap<K, V> extends LinkedHashMap<K, V> {
        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > capacity;
        }
    }

    public LRU(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer value = lruLinkedHashMap.get(key);
        if (null == value) {
            return -1;
        }
        lruLinkedHashMap.remove(key);
        lruLinkedHashMap.put(key, value);
        return value;
    }

    public void put(int key, int value) {
        if (lruLinkedHashMap.containsKey(key)) {
            lruLinkedHashMap.remove(key);
        }
        lruLinkedHashMap.put(key, value);
    }
}