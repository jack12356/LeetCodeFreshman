package LongestPalindrome5;

import java.util.HashMap;

class Solution {
    public String longestPalindrome(String s) {
        int length = 1;
        int temptlength;
        HashMap <Integer,Integer> map = new HashMap();
        map.put(length, 0);
        int i = 0;
        if (s.length() <= 2) {
            if ((s.length() == 2 && s.charAt(0) == s.charAt(1)) ){
                return s;
            }
            if (s.length() == 0) {
                return null;
            }
            return s.substring(0,1);
        }
        if (s.length() == 3 && s.charAt(0) == s.charAt(1) && s.charAt(0) == s.charAt(2)) {return s;}

        for (int j = 1; j < s.length(); j++) {
            if ((s.charAt(j) == s.charAt(j - 1)) || (j - 2 >= 0 && (s.charAt(j) == s.charAt(j - 2)))) {

                int temcount = j;

                if (s.charAt(j) == s.charAt(j - 1)) {
                    temptlength = 2;
                    int temp = j;
                    j++;
                    i = 3;
                    while ((j < s.length() && s.charAt(j) == s.charAt(temp)&&(judge(temp,j,s))) || ((j - i) >= 0 && j < s.length() && (s.charAt(j) == s.charAt(j - i)) )) {
                        i = (s.charAt(j) == s.charAt(temp)&&(judge(temp,j,s))) ? i + 1 : i + 2;
                        temptlength = (s.charAt(j) == s.charAt(temp)&&(judge(temp,j,s))) ? temptlength + 1 : temptlength + 2;
                        j++;
                    }
                    if (temptlength >= length) {
                        length = temptlength;
                        map.put(length, j - 1);
                    }
                }
                if (j < s.length() && s.charAt(j) == s.charAt(j - 2)) {
                    i = 1;

                    while ((j - i - 1) >= 0 && j < s.length() && s.charAt(j) == s.charAt(j - i - 1)) {
                        j++;
                        i += 2;
                    }
                    if (i >= length) {
                        length = i;
                        map.put(length, j - 1);
                    }
                }

                j = temcount;
            }
        }
        String result = s.substring(map.get(length) - length + 1, map.get(length) + 1);
        return result;
    }

    private boolean judge(int temp, int j, String s) {
        for (int i = temp + 1; i < j; i++) {
            if (s.charAt(i)!=s.charAt(temp)){
                return false;
            }
        }
        return true;
    }

    public String longestcommon(String s) {

        StringBuffer s0 = new StringBuffer(s);
        StringBuffer s1 = new StringBuffer(s).reverse();
        String common = MaxSubString(s0.toString(), s1.toString());
//        String common = MaxSubString(s);
        return common;
    }

    public String MaxSubString(String s0,String s1) {
        // TODO 自动生成的方法存根
        String temp = new String("");
        for(int i = 0;i<s0.length();i++)//先从短字符串的长度开始，逐步递减长度，直到出现符合的字符串
        {
            for(int j = 0,k = s0.length()-i;k<=s0.length();j++,k++)
            {
                if (s0.charAt(k - 1) == s0.charAt(j)) {
                    temp = s0.substring(j, k);
                    if (s1.substring(s1.length() - k, s1.length() - j).equals(temp)) {
                        return temp;
                    }
                }
            }
        }
        return null;
    }

    public String brutal(String s) {
        boolean flag;
        for(int i = 0;i<s.length();i++)//先从短字符串的长度开始，逐步递减长度，直到出现符合的字符串
        {
            for (int j = 0, k = s.length() - i; k <= s.length(); j++, k++) {
//                flag = true;
//                for (int l = 0; l <= (k - j) /2; l++) {
//                        if (s.charAt(j + l) != s.charAt(k - l - 1)){
//                            flag = false;
//                            break;
//                        }
//                    }
//                if (flag)return s.substring(j, k);
                int tempj = j,tempk = k;
                while (s.charAt(j) == s.charAt(k - 1)&&k-1>j) {
                    j++;
                    k--;
                }
                if (j == (k + j) / 2) {
                    return s.substring(tempj, tempk);
                } else {
                    j = tempj;
                    k = tempk;
                }
            }
        }
        return null;
    }

    public String longestPalindromeLeetCode(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public String longestPalindrome_dp(String s) {
        int len = s.length();
        if(s == null || len == 0){
            return s;
        }
        String res = "";
        int max = 0;
        //创建一个行列均为字符串长度的二维数组，创建时默认初始化为false
        boolean[][] dp = new boolean[len][len];
        for(int j = 0; j < len; j++){
            for(int i = 0; i <= j; i++){//这里只考虑了i<=j的情况，因为i>j时均为false
                                        //当i==j,j-i==1,j-i==2时，只要满足s.charAt(i) == s.charAt(j)就是回文字符串
                                        //如果不是这样，还要判断当前回文字符串的子串是不是回文字符串，即dp[i + 1][j - 1])，这就是动
                                        //态规划思想
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1]);
                if(dp[i][j]){//如果是回文字符串
                    if(j - i + 1 > max){//并且比之前的回文字符串要长，更新字符串长度，记录字符串
                        max = j - i + 1;
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "babad";
        //String result = solution.longestPalindrome(s);
        long startMili=System.currentTimeMillis();
        String result = solution.longestPalindromeLeetCode(s);
        long endMili=System.currentTimeMillis();
        System.out.println("longestPalindromeLeetCode: "+(endMili-startMili)+" ms");

        result = solution.longestPalindrome(s);
        long endMili2=System.currentTimeMillis();
        System.out.println("longestPalindrome: "+(endMili2-endMili)+" ms");

        result = solution.brutal(s);
        long endMili3=System.currentTimeMillis();
        System.out.println("brutal: "+(endMili3-endMili2)+" ms");
        System.out.println(result);


//        System.out.println(result);
    }
}