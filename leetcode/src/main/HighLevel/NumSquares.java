public class NumSquares {
    public int numSquares(int n) {
        if (Math.sqrt(n)%1==0) return 1;
        int subSqrt = (int)Math.sqrt(n);
        int []dp = new int[n+1];
        return numSq(n, dp);
    }
    public int numSq(int n, int[]dp){
        if (Math.sqrt(n)%1==0) {
            dp[n] = 1;
            return 1;
        }
        int subSqrt = (int)Math.sqrt(n);
        int minNum = Integer.MAX_VALUE;
        for (int i = subSqrt; i > 0; i--) {
            int sub = n-i*i;
            if (dp[sub]==0) dp[sub] = numSq(sub, dp);
            minNum = Math.min(minNum,dp[sub]);
        }
        dp[n] = minNum+1;
        return dp[n];
    }
}
