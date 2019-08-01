import java.util.*;

public class LRUCache {
//    HashMap<Integer, Integer> map = new HashMap<>();
//    Queue<Integer> queue = new LinkedList<>();
    LinkedHashMap<Integer, Integer> lmap;
    int size;
    public LRUCache(int capacity) {
        size = capacity;
        lmap = new LinkedHashMap<>(capacity);
    }

    public int get(int key) {
        if (lmap.containsKey(key)){
            int value = lmap.get(key);
            lmap.remove(key);
            lmap.put(key, value);
            return value;
        }else return -1;
    }

    public void put(int key, int value) {
        if (lmap.containsKey(key)){
            lmap.remove(key);
            lmap.put(key, value);
            return;
        }
        if (lmap.size()>=size&&!lmap.isEmpty()){
            lmap.remove(lmap.keySet().toArray()[0]);
        }
        lmap.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */