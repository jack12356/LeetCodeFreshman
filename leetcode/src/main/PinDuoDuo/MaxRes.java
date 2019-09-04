package PinDuoDuo;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
class QueryIndex{
    int sim;
    int index;
    QueryIndex(int x, int y){
        sim = x;
        index = y;
    }
}
public class MaxRes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String line2 = sc.nextLine();
        int x = sc.nextInt();
        List<Integer> res = solve(x, line1, line2);
        System.out.println(res.toString());
    }

        private static List<Integer> solve(int x, String line1, String line2) {
            String[] strs1 = line1.split(",");
            String[] strs2 = line2.split(",");
            List<PriorityQueue<QueryIndex>> list = new ArrayList<>();
            List<Integer> res = new ArrayList<>();
            int last_index = 0;
            for (int i = 0; i < strs1.length; i++) {
                PriorityQueue<QueryIndex> heap = new PriorityQueue<>();
                for (int j = last_index + 1; j < strs2.length && j < last_index + x + 1; j++) {
                    int sim = similar(strs1[i], strs2[j]);
                    QueryIndex q = new QueryIndex(sim, j);
                    heap.add(q);
                }
                list.add(heap);
            }
            for (int i = 0; i < list.size(); i++) {
                res.add(list.get(i).peek().index);
            }

            return res;
        }

        private static int similar(String s, String s1) {
            return 0;
        }
}
