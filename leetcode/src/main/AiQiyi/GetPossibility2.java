package AiQiyi;

import java.util.Scanner;

public class GetPossibility2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        getPosibility(n, m);
    }

    private static void getPosibility(int n, int m) {
        if(n==0) System.out.printf("%.5f",0F);
        if(m==0) System.out.printf("%.5f",1F);
        float [][]dp = new float[n+1][m+1];
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = 1F;
        }
        for (int i = 1; i < m + 1; i++) {
            dp[0][i] = 0F;
        }
        dp[0][0] = 0F;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                float ni = (float) i;
                float mj = (float) j;
                if(j==1) {
                    dp[i][j] = ni/(ni+1);
                    continue;
                }
                if(j==2){
                    dp[i][j] = (ni / (ni + 2)) + (2 / (ni + 2)) * (1 / (ni + 1)) * dp[n - 1][0];
                    continue;
                }
                dp[i][j] = (ni / (ni + mj)) + (mj / (ni + mj)) * ((mj - 1) / (ni + mj - 1)) * ( (ni / (ni + mj - 2)) * dp[i - 1][j - 2] + (dp[i][j - 3] * (mj - 2) / (ni + mj - 2)));
            }
        }
        System.out.printf("%.5f",dp[n][m]);
    }
}
