package DaJiang;

import java.util.Scanner;

public class BagsGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int X = sc.nextInt();
            int[] games = new int[N];
            int[] times = new int[N];
            for (int j = 0; j < N; j++) {
                games[i] = sc.nextInt();
                times[i] = sc.nextInt();
            }
            int res = solve(games, times, X, N);
            System.out.println(res);

        }
    }

    private static int solve(int[] values, int[] weights, int X, int N) {
        int[][] dp = new int[N + 1][X + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < X + 1; j++) {
                if (weights[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
                }
            }
        }
        return dp[N][X];
    }
}
