package Alibaba;

import java.util.*;

public class FindPair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int threshold = sc.nextInt();
        int minLen = sc.nextInt();
        int maxLen = sc.nextInt();
        sc.nextLine();
        String line1 = sc.nextLine();
        String line2 = sc.nextLine();
        String []strs1 = line1.split(",");
        String []strs2 = line2.split(",");
        int res = solve(strs1, strs2, threshold, minLen, maxLen);
        System.out.println(res);
    }

    private static int solve(String[]strs1, String []strs2, int threshold, int minLen, int maxLen) {
        int len_min = Math.min(strs1.length, strs2.length);
        if (strs1.length > strs2.length) {
            String []t =  strs1;
            strs1 = strs2;
            strs2 = t;
        }
        int res = 0;
        for (int i = 0; i < len_min - minLen; i++) {
            for (int j = i + minLen - 1; j < i + maxLen; j++) {
                res += solve2(strs1, strs2, threshold, i, j,maxLen,minLen);
            }
        }
        return res;
    }

    private static int solve2(String[] strs1, String[] strs2, int threshold, int st, int end, int minLen, int maxLen) {
        int cnt = 0;
        int strs1Len = end - st + 1;
        int [][]dp = new int[strs1Len+1][strs2.length+1];
        for (int i = 1; i <= strs1Len; i++) dp[i][0]=i;
        for (int i = 1; i <= strs2.length; i++) dp[0][i]=i;
        for (int i = 1; i <= strs1Len; i++) {
            for (int j = 1; j <= strs2.length; j++) {
                if (st + i - 1 < strs1.length && strs1[st + i - 1].equals(strs2[j - 1])) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1), dp[i - 1][j - 1] + 1);
                }
                if (dp[i][j] <= threshold && Math.min(i, j) >= minLen && Math.min(i, j) <= maxLen) {
                    cnt += 1;
                }
            }
        }
        return cnt;
    }
}
