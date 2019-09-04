package Kuai;
/*
sin:
5
1 2 3 4 5
1 1 1 1 1

sout:
11 12 13 14 15
 */
import java.util.Scanner;

public class Excise_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dist = new int[N];
        int[] E = new int[N];
        for (int i = 0; i < N; i++) {
            dist[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            E[i] = sc.nextInt();
        }
        for (int i = 1; i <= N; i++) {
            int[] max = new int[1];
            max[0] = 0;
            solve(N, dist, E, i, max, 0, -1, 0);
            System.out.println(max[0]);
        }
    }

    private static void dpExcise(int N,int []dist,int[]E){
        //初始化动态规划数组
        int[][] dp = new int[N+1][N+1];
        //为了便于理解,将dp[i][0]和dp[0][j]均置为0，从1开始计算
            for(int j=1;j<N+1;j++){
                for(int i=1;i<N+1;i++){
                    //如果第i件物品的重量大于背包容量j,则不装入背包
                //由于weight和value数组下标都是从0开始,故注意第i个物品的重量为weight[i-1],价值为value[i-1]
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + E[i - 1] + 2*(dist[i-1]-dist[i-2]));
            }
        }
        System.out.println(dp[N][N]);
    }

    private static void solve(int n, int[] dist, int[] e, int k, int[] max,int cnt,int cur, int presum) {
        if(cnt==k){
            max[0] = Math.max(max[0], presum + dist[cur]);
            return;
        }
        for (int i = cur + 1; i < n; i++) {
            int t = cur == -1 ? 0 : dist[cur];
            solve(n, dist, e, k, max, cnt + 1, i, presum + e[i] + dist[i] - t);
        }
    }
}
