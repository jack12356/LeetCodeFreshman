import java.util.Scanner;
import java.util.Stack;

public class GetMinPrince_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int Q = sc.nextInt();
        int[][] w = new int[N + 1][N + 1];
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                w[i][j] = i==j ? 0:Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < M; i++) {
            int st = sc.nextInt();
            int end = sc.nextInt();
            w[st][end] = sc.nextInt();
        }
        for (int i = 0; i < Q; i++) {
            int s = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();
            int p = sc.nextInt();
            int res = solve(w,N,M,s,l,r,p);
            System.out.println(res);
        }
    }

    private static int solve(int[][] wt, int N, int M, int S, int L, int R, int p) {
        int[][] w = new int[N + 1][N + 1];
        for (int k = 0; k < N + 1; k++) {
            for (int j = 0; j < N + 1; j++) {
                w[k][j] = wt[k][j];
            }
        }
        int res;
        int[] toNPrice = floyd(w, 1, S, N);
        int toSPrcie = toNPrice[0];
        int noSNPrice = toNPrice[1];
        for (int i = L; i <= R ; i++) {
            w[S][i] = Math.min(w[S][i],p);
        }
        int []toStoNPrice = floyd(w, S, S, N);
        int toStoN = toStoNPrice[1] + toSPrcie;
        res = Math.min(noSNPrice, toStoN);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private static int [] floyd(int[][] weight, int st, int end,int end2) {
        int N = weight.length;
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = weight[i][j];
            }
        }
        for(int k = 1; k < N; k++)
            for(int i = 1; i < N; i++)
                for(int j = 1;j < N; j++)
                    if(dp[i][j]>dp[i][k]+dp[k][j])
                        dp[i][j] = dp[i][k] + dp[k][j];
        return new int[]{dp[st][end],dp[st][end2]};
    }

}

