package StringtoInteger8;

class Solution {
    public int myAtoi(String str) {
        StringBuilder sr = new StringBuilder(str);
        StringBuilder sr1 = new StringBuilder();
        boolean first = true;
        boolean isNegative = false;
        for (int i = 0; i < sr.length(); i++) {
            if (!Character.isDigit(sr.charAt(i))) {
                if (first){
                    if (sr.charAt(i)=='-'){
                        isNegative = true;
                        first = false;
                        continue;
                    }
                    if (sr.charAt(i)=='+'){
                        first = false;continue;}
                    if (sr.charAt(i) == ' ') {
                        continue;
                    }
                    return 0;
                }
                break;
            }
            sr1.append(sr.charAt(i));
            first = false;
        }
        long result = 0;
        for (int i = 0; i <sr1.length(); i++) {
            result*=10;
            result += sr1.charAt(i)-48;
            if (!isNegative&&result > (Integer.MAX_VALUE)) return Integer.MAX_VALUE;
            if (isNegative && result > (long) Integer.MAX_VALUE + 1) return Integer.MIN_VALUE;
        }
        result = (!isNegative) ? result:-result;
        return (int)result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s ="-54321";
        System.out.println(solution.myAtoi(s));
    }
}