package RandomizedSet;

import java.util.*;

public class RandomizedSet {
    List<Integer> list;
    Map<Integer, Integer> map;
    Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }else{
            list.add(val);
            map.put(val, list.size() -1);
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)){
            int index = map.get(val);
            if(list.size() != index+1){
                int last = list.get(list.size()-1);
                list.set(list.size()-1, val);
                list.set(index, last);
                map.put(last, index);
            }
            list.remove(list.size()-1);
            map.remove(val);
            return true;
        }else{
            return false;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        boolean param_1 = obj.insert(1);
        boolean param_2 = obj.insert(2);
        boolean param_3 = obj.remove(2);
        int param_4 = obj.getRandom();
        System.out.println(param_4);
    }
}
