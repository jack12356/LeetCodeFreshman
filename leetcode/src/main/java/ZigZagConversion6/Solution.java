package ZigZagConversion6;


/**
 The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 (you may want to display this pattern in a fixed font for better legibility)
 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"
 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class Solution {
    public String convert(String s, int numRows) {
        StringBuffer []sb = new StringBuffer[numRows];
        char[] chars = s.toCharArray();
        int len = chars.length;
        if (numRows == 1) {
            return s;
        }
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuffer();
        }
        int incre;
        boolean flag = true;
        for (int j = 0,i=0; i < len; i++) {
            sb[j].append(chars[i]);
            if (j==0) flag = true;
            incre = (flag == true) ? 1 : -1;
//            incre = (j == numRows - 1) ? (j == 0) ? 1 : -1 : 1;
            j += incre;
            if (j==numRows-1) flag = false;
        }
        StringBuffer re = new StringBuffer();
        for (int i = 0; i < numRows; i++) {
            re.append(sb[i]);
        }

        return re.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "AB";
        System.out.println(solution.convert(s, 1));
    }
}
