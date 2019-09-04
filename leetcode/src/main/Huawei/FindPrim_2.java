package Huawei;

import java.util.Scanner;

public class FindPrim_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int low = sc.nextInt();
        int high = sc.nextInt();
        solve(low, high);
    }

    private static void solve(int low, int high) {
        boolean []dp = new boolean[high];
        for (int i = 0; i < high; i++) {
            dp[i] = true;
        }
        int geSum = 0;
        int shiSum = 0;
        for (int i = 2; i < high; i++) {
            if(dp[i]) {
                for (int j = 2; j * i < high; j++) {
                    dp[j * i] = false;
                }
                if (i >= low) {
                    geSum += i % 10;
                    shiSum += (i % 100) / 10;
                }
            }
        }
        System.out.print(Math.min(geSum,shiSum));
    }
}
