public class ChangeMoney {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i < amount+1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int coin:coins) {
            for (int i = 0; i < amount+1; i++) {
                if(i>=coin&&dp[i - coin]!=Integer.MAX_VALUE) dp[i] = Math.min(dp[i], dp[i - coin]+1);
            }
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }

    public static void main(String[] args) {
        int amount = 11;
        int[] coins = new int[]{1, 2, 5};
        System.out.println(new ChangeMoney().change(amount,coins));
    }
}
