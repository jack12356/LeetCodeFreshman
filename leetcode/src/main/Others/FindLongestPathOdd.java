import java.util.HashSet;
import java.util.Set;

public class FindLongestPathOdd {
    public static void main(String[] args) {

        int []T = new int[]{0,9,0,2,6,8,0,8,3,0};
//        int []T = new int[]{0,0,0,1,6,1,0,0};
        int res = new FindLongestPathOdd().solution(T);
        System.out.println(res);
    }

    private int solution(int []T) {
        Set<Integer> got = new HashSet<>();
        int num_odd = 0;
        got.add(0);
        int []max = new int[1];
        max[0]=-1;
        int dep = 1;
        int st = 0;
        dfs(T, st, got, max, dep, num_odd);
        return max[0];
    }

    private void dfs(int[] t, int st, Set<Integer> got, int[] max, int dep, int num_odd) {
        max[0] = Math.max(max[0], dep);
        for (int i = 0; i < t.length; i++) {
            if ((t[st] == i || t[i] == st) && !got.contains(i) && (i % 2 == 0 || num_odd == 0)) {
                got.add(i);
                if (i % 2 == 1) {
                    num_odd++;
                }
                dfs(t, i, got, max, dep + 1, num_odd);
            }
        }
    }
}
