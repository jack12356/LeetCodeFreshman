package CoinChange;


public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int [] min_coins = new int[amount+1];
        min_coins[0] = 0;
        for (int num = 1; num < amount+1; num++) {
            int min = Integer.MAX_VALUE;
            for (int coin :coins) {
                if((num-coin>=0&&min_coins[num-coin]!=-1)){
                    min = Math.min(min,min_coins[num-coin]+1);
                }
            }
            min_coins[num] = min==Integer.MAX_VALUE?-1:min;
        }
        return min_coins[amount];
    }

    public static void main(String[] args) {
        CoinChange su = new CoinChange();
        int[]nums = new int[]{3, 5};
        int amount = 7;
        System.out.println(su.coinChange(nums, amount));
    }
}
