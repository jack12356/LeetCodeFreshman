package leetcode其他题目;

public class MaxParentheses {
    public int getMaxParenthese(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int[] dp = new int[str.length()];
        char[] strs = str.toCharArray();
        for (int i = 1; i < strs.length; i++) {
            char cur = strs[i];
            int pre = i - dp[i - 1] - 1;
            if(cur==')'){
                if (pre > 0 && strs[pre] == '(') {
                    dp[i] = dp[i - 1] + 2 + (pre - 1 > 0 ? dp[pre - 1] : 0);
                }
            }
        }
        return dp[dp.length-1];
    }
}
