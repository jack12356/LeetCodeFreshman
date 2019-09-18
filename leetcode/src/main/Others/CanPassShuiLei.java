package Others;

import java.util.*;

/*
3 10.0 0.0 13.3 14.2 15.7 25.0 33.3 59.8  Y
1 70.0 0.0 40.5 60.5  N
1 70.0 0.0 40.5 60.5  N

5 40 0 0 20 2 40 2 70 80 10 170 60
 */

class ShuiLei{
    float x;
    float y;
    boolean up;
    boolean down;
}
public class CanPassShuiLei {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 1; i++) {
            List<ShuiLei> list = new ArrayList<>();
            int N = sc.nextInt();
            float R = sc.nextFloat();
            float D = sc.nextFloat();
            for (int j = 0; j < N; j++) {
                float x = sc.nextFloat();
                float y = sc.nextFloat();
                ShuiLei l = new ShuiLei();
                l.x = x;
                l.y = y;
                list.add(l);
            }
            solve(list, R, D);
        }
        sc.close();
    }

    private static void solve(List<ShuiLei> list, float r, float d) {
        List<List<ShuiLei>> lists = bfs(list, r);
        for (List<ShuiLei> vList : lists) {
            boolean up=false;
            boolean down=false;
            for (ShuiLei s : vList) {
                if (s.up) up = true;
                if (s.down) down = true;
            }
            if(up&&down){
                System.out.println("N");
                return;
            }
        }
        if(Math.abs(d-0)<1e-5){
            System.out.println("Y");
        }else{
            System.out.println("1");
        }
    }

    private static List<List<ShuiLei>> bfs(List<ShuiLei> list, double r ) {
        List<List<ShuiLei>> res = new ArrayList<>();
        if(list.size()==0) return res;
        while (!list.isEmpty()){
            ShuiLei s0 = list.get(0);
            list.remove(0);
            List<ShuiLei> curList = new ArrayList<>();
            Queue<ShuiLei> queue = new LinkedList<>();
            queue.add(s0);
            while (!queue.isEmpty()){
                ShuiLei st = queue.poll();
                if(st.y+r>100-1e-5){ st.up=true;}
                if(st.y-r<1e-5){ st.down=true;}
                curList.add(st);
                for (int i = list.size()-1;i>=0;i--) {
                    ShuiLei s = list.get(i);
                    if(Math.sqrt(Math.pow(s.x-st.x,2.0)+Math.pow(s.y-st.y,2.0))<2*r){     //xiangjiao
                        queue.add(s);
                        list.remove(i);
                    }
                }
            }
            res.add(curList);
        }
        return res;
    }
}
