package DaJiang;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Min_path {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int N = sc.nextInt();
            int P = sc.nextInt();
            int C = sc.nextInt();
            int[][] weight = new int[N+1][N+1];
            for (int i = 0; i < P; i++) {
                int st = sc.nextInt();
                int end = sc.nextInt();
                int w = sc.nextInt();
                weight[st][end] = w;
                weight[end][st] = w;
            }
            for (int i = 0; i < N+1; i++) {
                for (int j = 0; j < N+1; j++) {
                    if(weight[i][j]==0) weight[i][j] = Integer.MAX_VALUE;
                }
            }

            int res = 0;
            for (int j = 0; j < C; j++) {
                int st = 0;
                int end = sc.nextInt();
                int cur_min = solve(weight,st,end);
                res +=cur_min;
            }
            System.out.println(res);
        }
        sc.close();
    }

    private static int solve(int[][] weight, int st, int end) {
        if (st==end) {
            System.out.println(0);
            return 0;
        }
        int M = weight.length - 1;
        int []dist = new int[M+1];
        for (int i = 0; i < M+1; i++) {
            dist[i] = i == st ? 0 : Integer.MAX_VALUE;
        }

        Set<Integer> got = new HashSet<>();
        got.add(st);
        Set<Integer> other = new HashSet<>();
        for (int j=1;j<M+1;j++){
            if (j!=st) other.add(j);
        }

        while (dist[end] == Integer.MAX_VALUE) {
            int min_cur = Integer.MAX_VALUE;
            int node = -1;
            for (int cur : got) {
                for (int next : other) {
                    if (weight[cur][next] != Integer.MAX_VALUE && dist[cur] + weight[cur][next]< min_cur) {   //存在路径
                        min_cur = dist[cur] + weight[cur][next];
                        node = next;
                    }
                }
            }
            if (node==-1) break;
            dist[node] = min_cur;
            got.add(node);
            other.remove(node);
        }
        return  dist[end];
    }
}
