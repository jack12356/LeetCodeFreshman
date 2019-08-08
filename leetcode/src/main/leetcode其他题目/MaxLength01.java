package leetcode其他题目;

import java.util.Scanner;

public class MaxLength01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int num = get_max_len_0_1_parentheses(str);
        System.out.println(num);
    }

    private static int get_max_len_0_1_parentheses(String str) {
        int[] dp = new int[str.length()];
        char []chars = str.toCharArray();
        int res = 0;
        for (int i = 1; i < chars.length; i++) {
            char t = chars[i];
            int pre = i - dp[i - 1] - 1;
            if (pre >= 0 && chars[pre] != t) {
                dp[i] = dp[i - 1] + 2 + (pre - 1 > 0 ? dp[pre - 1] : 0);
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
}
