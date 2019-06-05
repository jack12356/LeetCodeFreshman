import java.util.*;

class TimeMap {
    Map<String, List<ValueTime>> map;
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        ValueTime vs = new ValueTime(value,timestamp);
        if(map.containsKey(key)){
            map.get(key).add(vs);
        }else{
            List<ValueTime> list = new ArrayList<>();
            list.add(vs);
            map.put(key, list);
        }
    }

    public String get(String key, int timestamp) {
        if(map.containsKey(key)){
            List<ValueTime> list = map.get(key);
            int index = list.size()-1;
            while (index>=0 && list.get(index).timestamp>timestamp){
                index--;
            }
            if(index<0) return "";
            else return list.get(index).value;
        }else {
            return null;
        }
    }

    public static void main(String[] args) {
        TimeMap tm = new TimeMap();
        tm.set("foo","bar",1);
        System.out.println(tm.get("foo", 1));
        System.out.println(tm.get("foo", 3));
        tm.set("foo","bar2",4);
        System.out.println(tm.get("foo", 4));
        System.out.println(tm.get("foo", 5));
    }

}


class ValueTime{
    String value;
    int timestamp;
    ValueTime(String v,int t){
        value = v;
        timestamp = t;
    }
}