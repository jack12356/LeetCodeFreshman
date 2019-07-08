import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N = sc.nextInt();
        int[][] weight = new int[N+1][N+1];
        int[][]res = new int[N + 1][N + 1];
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                res[i][j] = i == j ? 0 : Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < N-1; i++) {
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
        int Q = sc.nextInt();
        Main test = new Main();
        for (int i = 0; i < Q; i++) {
            int st = sc.nextInt();
            int max = test.solve(weight,st,res);
            System.out.println(max);
        }
        sc.close();
    }

    private int solve(int[][] weight, int st,int[][]res) {
        int M = weight.length - 1;
        int[] dist = new int[M + 1];
        for (int i = 0; i < M + 1; i++) {
            dist[i] = i == st ? 0 : Integer.MAX_VALUE;
        }

        Set<Integer> got = new HashSet<>();
        got.add(st);
        Set<Integer> other = new HashSet<>();
        for (int j = 1; j < M + 1; j++) {
            if (j != st) other.add(j);
        }
        int max = -1;
        for (int i=1;i<M+1;i++) {
            if(!other.contains(i)) continue;
            if(res[st][i]!=Integer.MAX_VALUE){
                dist[i] = res[st][i];
                max = Math.max(max, res[st][i]);
                got.add(i);
                other.remove(i);
            }
        }

        while (got.size() != M) {
            int min_cur = Integer.MAX_VALUE;

            int node = -1;
            for (int cur : got) {
                for (int next : other) {
                    if (weight[cur][next] != Integer.MAX_VALUE && dist[cur] + weight[cur][next] < min_cur) {   //存在路径
                        min_cur = dist[cur] + weight[cur][next];
                        node = next;
                    }
                }
            }
            if (node == -1) break;
            max = Math.max(max, min_cur);
            dist[node] = min_cur;
            res[st][node] = min_cur;
            res[node][st] = min_cur;
            got.add(node);
            other.remove(node);
        }
        return max;

    }
}
