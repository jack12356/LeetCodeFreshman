package Others;

import java.util.*;

/*

5 2
1 4
3 4
4

5 3
1 4
3 4
2 5

3 3
1 2
1 3
2 3
 */
public class DIffTrash {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[][] w = new boolean[n+1][n+1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            w[a][b] = true;
        }
        solve(w,n);
    }

    private static void solve(boolean[][] w, int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        List<Set<Integer>> heapList = new ArrayList<>();
        while (!list.isEmpty()){
            Set<Integer> got = new HashSet<>();
            got.add(list.get(list.size() - 1));
            list.remove(list.size() - 1);
            for (int i = list.size()-1; i >=0 ; i--) {
                int cur = list.get(i);
                boolean canAdd = true;
                for(int pre : got){
                    if(w[cur][pre]) canAdd = false;
                }
                if(canAdd){
                    list.remove(i);
                    got.add(cur);
                }
            }
            heapList.add(got);
        }


        int max = 0;
        int mid = 0;
        for (Set s: heapList) {
            int num = s.size();
            if(num>max){
                mid = max;
                max = num;
            }else if(num>mid){
                mid = num;
            }
        }
        int res = max % 2 == 0 ? Math.max(max / 2, mid) : mid;
        System.out.println(2 * res);
    }
}
