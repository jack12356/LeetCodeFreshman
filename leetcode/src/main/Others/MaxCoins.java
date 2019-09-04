package Others;

import java.util.Scanner;

public class MaxCoins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String []strs = str.split(" ");
        int []nums = new int[strs.length];
        for (int i = 0; i < nums.length; i++) nums[i] = Integer.parseInt(strs[i]);
        MaxCoins test = new MaxCoins();
        System.out.println(test.maxCoins(nums));
    }
    public int maxCoins(int[] nums) {
        int len = nums.length;
        int[] langarr = new int[len+2];
        langarr[0] = 1;
        for (int i = 0, j = 1; i < len; i++, j++) langarr[j] = nums[i];
        len = langarr.length;
        int[][] dp = new int[len][len];
        langarr[len-1] = 1;
        for (int i = 2; i < len; i++) {
            for (int j = 0; j+i < len; j++) {
                for (int k = j+1; k < j+i; k++) {
                    dp[j][j+i] = Math.max(dp[j][j+i], dp[j][k]+dp[k][j+i]+langarr[j]*langarr[k]*langarr[j+i]);
                }
            }
        }
        return dp[0][len-1];
    }
}
