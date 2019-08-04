package Huawei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Min_Path {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int M=sc.nextInt();
        int N = sc.nextInt();
        int[][] weight = new int[M+1][M+1];
        for (int i = 0; i < N; i++) {
            sc.nextInt();
            int st = sc.nextInt();
            int end = sc.nextInt();
            int w = sc.nextInt();
            weight[st][end] = w;
            weight[end][st] = w;
        }
        for (int i = 0; i < M+1; i++) {
            for (int j = 0; j < M+1; j++) {
                if(weight[i][j]==0) weight[i][j] = Integer.MAX_VALUE;
            }
        }
        int st = sc.nextInt();
        int end = sc.nextInt();
        Min_Path test = new Min_Path();
        test.solve(weight,st,end);
    }

    private void solve(int[][] weight, int st, int end) {
        if (st==end) {
            System.out.println(0);
            return;
        }
        int M = weight.length - 1;
        int []dist = new int[M+1];
        for (int i = 0; i < M+1; i++) {
            dist[i] = i == st ? 1 : Integer.MAX_VALUE;
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
                    if (weight[cur][next] != Integer.MAX_VALUE && dist[cur] + weight[cur][next] - 1 < min_cur) {   //存在路径
                        min_cur = dist[cur] + weight[cur][next] - 1;
                        node = next;
                    }
                }
            }
            if (node==-1) break;

            dist[node] = min_cur;
            got.add(node);
            other.remove(node);
        }
        if (dist[end]==Integer.MAX_VALUE) {
            System.out.println("NA");
            return;
        }
        System.out.println(dist[end]);
    }
}
