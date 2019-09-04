package Alibaba;

import java.util.Scanner;

public class MinNumsAddAtoB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int minSteps = getMinSteps(a, b);
        System.out.println(minSteps);
    }

    private static int getMinSteps(int a, int b) {
        int[] dp = new int[b - a + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        int[] scores = new int[]{3, 5, 7};
        dp[0] = 0;
        for (int i = 0; i+a <= b; i++) {
            for (int score :scores) {
                if (a + i + score <= b && dp[i] != Integer.MAX_VALUE) {
                    dp[i + score] = Math.min(dp[i + score], dp[i] + 1);
                }
            }
        }
        return dp[b - a];
    }
}
