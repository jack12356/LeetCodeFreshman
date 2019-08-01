import java.util.*;

public class ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                if (p1[0] == p2[0]) return p1[1] - p2[1];
                return p2[0] - p1[0];
            }
        };
        Arrays.sort(people, comparator);
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] person : people) list.add(person[1],person);
        return list.toArray(new int[people.length][]);
    }
}
