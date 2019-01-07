package IntegertoRoman12;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Given an integer, convert it to a roman numeral.

 Input is guaranteed to be within the range from 1 to 3999.
 */

class Solution {

    public static String intToRoman(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }

    public int romanToInt(String s) {
        StringBuilder M1 = new StringBuilder();
        StringBuilder C1 = new StringBuilder();
        StringBuilder X1 = new StringBuilder();
        StringBuilder I1 = new StringBuilder();

        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        int i = 0;
        int res = 0;
        while (i < s.length() &&(s.charAt(i) == 'M')) {
            M1.append('M');
            i++;
        }
        while (i < s.length() &&(s.charAt(i) == 'C'||s.charAt(i) == 'D'||s.charAt(i) == 'M')) {
            C1.append(s.charAt(i));
            i++;
        }
        while (i < s.length() &&(s.charAt(i) == 'X'||s.charAt(i) == 'L'||s.charAt(i) == 'C')) {
            X1.append(s.charAt(i));
            i++;
        }
        while (i < s.length() && (s.charAt(i) == 'I' || s.charAt(i) == 'V' || s.charAt(i) == 'X' || s.charAt(i) == ' ')) {
            I1.append(s.charAt(i));
            i++;
        }
        for (int j = 0; j < M.length; j++) {
            if (M1.toString().equals(M[j])) {
                res+=j*1000;
            }
        }
        for (int j = 0; j < C.length; j++) {
            if (C1.toString().equals(C[j])) {
                res+=j*100;
            }
        }
        for (int j = 0; j < X.length; j++) {
            if (X1.toString().equals(X[j])) {
                res+=j*10;
            }
        }
        for (int j = 0; j < I.length; j++) {
            if (I1.toString().equals(I[j])) {
                res+=j;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String test = intToRoman(2001);
        System.out.println(test);
        System.out.println(solution.romanToInt(test));
    }
}