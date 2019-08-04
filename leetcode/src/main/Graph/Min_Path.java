package Graph;

import java.util.Scanner;

public class Min_Path {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int EdgeNum = sc.nextInt();
        int[][] weight = new int[N+1][N+1];
        for (int i = 0; i < N + 1; i++) for (int j = 0; j < N + 1; j++) weight[i][j] = Integer.MAX_VALUE;
        for (int i = 0; i < EdgeNum; i++) {
            int st = sc.nextInt();
            int end = sc.nextInt();
            weight[st][end] = sc.nextInt();
        }
        int st = sc.nextInt();
        int end = sc.nextInt();
        int min_dist = dijkstra(weight, st, end);
        System.out.println(min_dist);
    }

    private static int floyd(int[][] weight, int st, int end) {
        int N = weight.length;
        int[][] dp = new int[N][N];
        for(int k = 0; k < N; k++)
            for(int i = 0; i < N; i++)
                for(int j = 0;j < N; j++)
                    if(dp[i][j]>dp[i][k]+dp[k][j])
                        dp[i][j] = dp[i][k] + dp[k][j];
        return dp[st][end];
    }



        //不管weight是否+1了
    private static int dijkstra(int[][] weight, int st, int end) {
        int N = weight.length;
        int []dist = new int[N];
        for (int i = 0; i < N; i++) {
            dist[i] = i == st ? 0 : Integer.MAX_VALUE;
        }
        while (dist[end] == Integer.MAX_VALUE) {
            int min_cur = Integer.MAX_VALUE;
            int node = -1;
            for (int cur = 0; cur < dist.length; cur++) {
                if (dist[cur] != Integer.MAX_VALUE) {       // 看那些到过的点
                    for (int next = 0;next<dist.length;next++) {
                        if(dist[next]==Integer.MAX_VALUE){  // 看那些没到过的点
                            if (weight[cur][next] != Integer.MAX_VALUE && dist[cur] + weight[cur][next] < min_cur) {   //存在路径
                                min_cur = dist[cur] + weight[cur][next];
                                node = next;
                            }
                        }
                    }
                }
            }
            if (node==-1) return Integer.MAX_VALUE;        // 没找到
            dist[node] = min_cur;
        }
        return  dist[end];
    }
}
