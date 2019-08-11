package PinDuoDuo;

import java.util.Scanner;


public class FindSumNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Sum = sc.nextInt();
//        int res = solve(N, Sum,0,0,0);
//        System.out.println(res);
        int resdp = getNumDp(N, Sum);
        System.out.println(resdp);
        int res2 = getNum(N, Sum);
        System.out.println(res2);
    }

    /*
       可以递归处理，长度为N，和为S的数列个数，
       dp[i][j]表示长度为i，和为j，满足严格递增正整数数列的个数；
       那么dp[i][j] = sum( dp[i - 1][j - k * i] ) for k in ( 1 , j/i)
       长度为N和为S的序列可以由（长度为N-1，和为X）的数列组合；

       假如找 dp[3][10] 中以1开头的组合，比如为（1,4,5）

       那么 1 后面的组合数目为
       （长为2，和为9，并且最小数至少从2开始）的组合数目   （ 比如 （4，5) ）
       将里面的两个数都减1，可转换为
       （长为2，和为7，并且最小数至少从1开始）的组合数目   （ 比如（3，4） ）
       同理有以2开头的dp[2][4]......
       所以 dp[3][10] =
                        dp[2][7]    // 以 1 开头，后面长为2，和为7组合数目 比如 (1,3,4)==>(1,4,5)
                        + dp[2][4]  // 以 2 开头，后面长为2，和为4 组合数目
       所以得到前面的递推式子；
     */
    private static int getNum(int N, int S){
        if (S <= 0 || N <= 0) return 0;
        if(N == 1) return 1;
        int num = 0;
        for (int i = 1; i <= S / N; ++i) {
            num += getNum(N - 1, S - i * N);
            num %= 1000000007;
        }
        return num;
    }

    private static int getNumDp(int N, int S){
        int[][] dp = new int[N + 1][S + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < S + 1; j++) {
                if(i==1) dp[i][j]=1;
                else {
                    for (int k = 1; k*i <= j; k++) {
                        dp[i][j] += dp[i - 1][j - k * i];
                        dp[i][j] %= 1000000007;
                    }
                }
            }
        }
        return dp[N][S];
    }

    private static int solve(int n, int sum, int cur, int cnt, int preSum) {
        if(sum==preSum&&cnt==n){
            return 1;
        }
        if(sum<preSum) return 0;
        int res = 0;
        for (int i = cur+1; i <= sum - preSum; i++) {
            if (cnt < n) {
                res += solve(n, sum, i, cnt + 1, preSum + i);
                res %= 1000000007;
            }
        }
        return res;
    }
}
