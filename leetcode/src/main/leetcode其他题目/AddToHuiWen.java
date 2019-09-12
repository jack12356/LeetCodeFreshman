package leetcode其他题目;

public class AddToHuiWen {
    public static int minAdd(String string) {
        char[] str = string.toCharArray();
        int len = str.length;
        int[][] dp = new int[len][len];//用于存储字符串从i位置到j位置构成汇文串需要最少添加的字符数量
        for(int k = 1 ; k < len ; k ++) {//i位置与j位置的间隔（自字符串长度-1），一般情况下，拆分成最小子问题时，k的初始值应为0，但因java创建数组是已经对每一个节点赋予了初始值0，故k为0时可以省略
            for(int i = 0; i+k < len ; i++) {
                int j = i + k ;
                if(str[i]==str[j]) {
                    dp[i][j]=dp[i+1][j-1];
                }else {
                    dp[i][j]=Math.min(dp[i+1][j],dp[i][j-1])+1;
                }
            }
        }
        return dp[0][len-1];
    }
}
