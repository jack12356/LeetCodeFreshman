package Huawei;

import java.util.*;

class Group{
    int gId;
    List<People> plist = new ArrayList<>();
    Group(int x){
        gId = x;
    }
}
class People{
    String name;
    List<Integer> glist = new ArrayList<>();
    People(String n){
        name = n;
    }
}
public class GroupTransNum_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st = sc.nextLine();
        int m = sc.nextInt();
        sc.nextLine();
        Map<Integer, Group> gmap = new HashMap<>();
        Map<String,People> pmap = new HashMap<>();
        for (int gId = 0; gId < m; gId++) {
            Group group = new Group(gId);
            String line = sc.nextLine();
            String []strs = line.split(",");
            if (strs.length==0) continue;
            for (String pName:strs) {
                if (pmap.containsKey(pName)) {
                    pmap.get(pName).glist.add(gId);
                }else {
                    People p = new People(pName);
                    p.glist.add(gId);
                    pmap.put(pName, p);
                }
                group.plist.add(pmap.get(pName));
            }
            gmap.put(gId, group);
        }
        sc.close();
        int res = 0;
        if(m!=0){
            res = getNum(gmap, pmap, st);
        }
        System.out.print(res);

    }

    private static int getNum(Map<Integer, Group> gmap, Map<String, People> pmap, String st) {
        Set<String> gotSet = new HashSet<>();
        Set<Integer> gotGroupSet = new HashSet<>();
        Queue<People> queue = new LinkedList<>();
        if(!pmap.containsKey(st))return 0;
        queue.add(pmap.get(st));
        gotSet.add(st);
        while (!queue.isEmpty()){
            People cur = queue.poll();
            for (int gId :cur.glist) {
                if(gotGroupSet.contains(gId)) continue;
                Group curGroup = gmap.get(gId);
                for (People curPinGroup : curGroup.plist) {
                    if (!gotSet.contains(curPinGroup.name)) {
                        gotSet.add(curPinGroup.name);
                        queue.add(curPinGroup);
                    }
                }
                gotGroupSet.add(gId);
            }
        }
        return gotSet.size();
    }
}
