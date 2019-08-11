package PinDuoDuo;

import java.util.*;

class Point{
    Set<Integer> in = new HashSet<>();
    int num;
    int t;
    Point(int n,int time){
        this.num = n;
        this.t = time;
    }
}
public class SortTask3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Point []task = new Point[n];
        for (int i = 0; i < n; i++) {
            task[i] = new Point(i+1,sc.nextInt());
        }
        for (int i = 0; i < m; i++) {
            int f = sc.nextInt();
            int l = sc.nextInt();
            task[l-1].in.add(f);
        }
        solve(task);
    }

    private static void solve(Point[] task) {
        Set<Integer> set = new HashSet<>();
        while (set.size() < task.length) {
            int min_index = -1;
            int min_time = Integer.MAX_VALUE;
            for (int i = 0; i < task.length; i++) {
                if(set.contains(i)) continue;
                Point cur = task[i];
                if(cur.in.size()==0){
                    if (cur.t < min_time) {
                        min_index = i;
                        min_time = cur.t;
                    }
                }
            }
            set.add(min_index);
            System.out.print((min_index + 1) + " ");
            // 去掉入度
            for (int i = 0; i < task.length; i++) {
                if(set.contains(i)) continue;
                Point cur = task[i];
                cur.in.remove(min_index+1);
            }
        }
    }

    private static void solve2(Point[] tasks) {
        PriorityQueue<Point> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.t));
        for (Point task : tasks) {
            if (task.in.size() == 0) queue.offer(task);
        }
        while (!queue.isEmpty()){
            Point cur = queue.poll();
            System.out.println(cur.num);
            for (Point p : tasks) {
                if (p.in.contains(cur.num)) {
                    p.in.remove(cur.num);
                    if (p.in.isEmpty()) {
                        queue.offer(p);
                    }
                }
            }
        }
    }
}