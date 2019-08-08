package leetcode其他题目;

import java.util.Arrays;

public class ChangeMoney2 {
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        return change2(amount, coins, coins.length-1);
    }

    private int change2(int amount, int []coins, int index) {
        int res = 0;
        if (amount==0) return 1;
        for (int i = index;i>=0; i--) {
            int coin = coins[i];
            if(amount>=coin){
                res+= change2(amount-coin, coins,i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = new int[]{1, 2, 5};
        System.out.println(new ChangeMoney2().change(amount, coins));
    }
}
