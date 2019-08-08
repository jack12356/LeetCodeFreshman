package DaJiang;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GetStacks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int N = sc.nextInt();
        int[] p = new int[N];
        for (int i = 0; i < N; i++) {
            p[i] = sc.nextInt();
        }
        int M = sc.nextInt();
        Set<Integer> got = new HashSet<>();
        int []p_new = new int[N];
        for (int i = 0; i < M; i++) {
            int t = sc.nextInt();
            got.add(t);
            p_new[i] = p[t];
        }
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (!got.contains(i)) {
                p[M + cnt] = p[i];
                cnt++;
            }
        }

        int res = getMaxNum(p_new, N, 0,V,Integer.MAX_VALUE);
        System.out.println(res);
    }


    private static int getMaxNum(int[] p, int N, int index, int V, int pre_num) {
        if (V < 0 || (index >= N && V != 0)) {
            return 0;
        }
        if(V==0){
            return 1;
        }
        int num = 0;
        for (int i = 1; (i < pre_num) && (i * p[index] <= V); i++) {
            num += getMaxNum(p, N,index + 1, V - i * p[index], i);
            num = num%1000000007;
        }
        return num;
    }
}
