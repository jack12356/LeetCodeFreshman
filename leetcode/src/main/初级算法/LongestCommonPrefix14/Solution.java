package LongestCommonPrefix14;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = "";
        if (strs.length==0)return res;
        int minLength = strs[0].length();
        for (int i = 0; i < minLength; i++) {
            char c = strs[0].charAt(i);
            for (String s:strs) {
                int len = s.length();
                if (len==0) return res;
                minLength=(minLength>len)?len:minLength;
                if (s.charAt(i) != c) {
                    return res;
                }
            }
            res+=c;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"abcghasasdfgdtdfgdf", "abcdssaedses", "abchjjjdgedfgswdrd"};
        System.out.println(solution.longestCommonPrefix(strs));
    }
}