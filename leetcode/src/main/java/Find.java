import java.util.Arrays;

class Solution {
    public String longestPalindrome(String s) {
        int n = 0;
        for (int i = 1, j = 1; j < s.length(); i++) {
            if (s.length() == 1) {
                return Arrays.toString(new char[]{s.charAt(0)});
            }
            while ((s.charAt(j)==s.charAt(j-i))||(s.charAt(j)==s.charAt(j-i-1))) {

                n++;
                i+=2;
                j++;
            }
        }
        return null;
    }
}