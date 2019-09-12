package AiQiyi;

import java.util.HashSet;
import java.util.Scanner;

public class Permute1 {
    int res = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n-1];
        for (int i = 0; i < n-1; i++) {
            A[i] = sc.nextInt();
        }
        Permute1 test = new Permute1();
//        HashSet<Integer> got = new HashSet<>();
//        test.dfs(n, A,-1,got);
//        System.out.println(test.res);
        System.out.println(test.numPermsDISequence(A));

    }

    private void dfs(int n, int[] a, int cur, HashSet<Integer> got) {
        if(n==0) return;
        if(n==1){
            res++;
            return;
        }
        if(got.size()==n){
            res++;
            res %= 1000000007;
            return;
        }
        int cur_index = got.size() - 1;
        for (int i = 1; i <= n; i++) {
            if (got.contains(i)) {
                continue;
            }
            if (cur_index == -1 || (a[cur_index] == 1 && cur > i) || (a[cur_index] == 0 && cur < i)) {
                got.add(i);
                dfs(n, a, i, got);
                got.remove(i);
            }
        }
    }

    public int numPermsDISequence(int[] S) {
        int N = S.length + 1;
        int MOD = 1000000007;
        int [][]dp = new int[N+1][N+1];
        for (int i = 0; i < N + 1; i++) {
            dp[0][i] = 1;
        }
        dp[1][1] = 1;
        for (int i = 2; i <= N; ++i) {
            for (int j = 1; j <= i; ++j) {
                if (S[i - 2] == '0') {
                    dp[i][j] = ( j == 0 ? 0 : dp[i][j-1]  - dp[i-1][j-1] ) + dp[i-1][i-1];
//                    dp[i][j] = (dp[i][j-1] + (dp[i-1][i-1] - dp[i-1][j-1]) % MOD) % MOD;
                } else {
                    dp[i][j] = j == 0 ? 0 : dp[i][j-1] + dp[i-1][j-1];
//                    dp[i][j] = (dp[i][j-1] + (dp[i-1][j-1] - dp[i-1][0]) % MOD) % MOD;
                }
            }
        }
        return (dp[N][N] + MOD) % MOD;
    }
}
