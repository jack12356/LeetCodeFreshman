import java.util.*;

public class NumXOr {
    Set<Integer> set = new HashSet<>();
    List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        NumXOr test = new NumXOr();
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int n = sc.nextInt();
            int qes = sc.nextInt();
            test.add(n);
            boolean res = test.question(qes);
            System.out.println(res);
        }
        sc.close();
    }

    private boolean question(int q) {
        if (set.contains(q)) {
            return true;
        }
        boolean []r = new boolean[1];
        dfs(q, 0, r,0);
        return r[0];
    }

    private void dfs(int q, int i, boolean[] r, int pre) {
        if(r[0]) return;
        if (pre == q) {
            r[0] = true;
            return;
        }
        if (i >= list.size()) {
            return;
        }
        for (int j = i; j < list.size(); j++) {
            dfs(q,j+1,r,pre);
            pre = pre | list.get(j);
            dfs(q,j+1,r,pre);
        }

    }

    private void add(int q) {
        if (!set.contains(q)) {
            set.add(q);
            list.add(q);
        }
    }


}
