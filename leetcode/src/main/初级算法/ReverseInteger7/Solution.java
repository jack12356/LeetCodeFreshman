package ReverseInteger7;

/**
 Reverse digits of an integer.

 Example1: x = 123, return 321
 Example2: x = -123, return -321
 */

public class Solution {
    public int reverse(int x) {
        Integer integer = Math.abs(x);
        StringBuilder st = new StringBuilder(integer.toString());
        String st1 = st.reverse().toString();
        int result;
        try {
            result = (x<0)? -Integer.valueOf(st1):Integer.valueOf(st1);
        } catch (NumberFormatException e) {
            return 0;
        }
        return result;
    }

    public int reverse2(int n) {
        long reverse = 0;
        int tmp = 0;
        //to reverse the number.
        while (n != 0) {
            tmp = n % 10; //pic the first elemnt
            reverse*=10; //shift the elements to the left
            reverse += tmp; //add the element
            //to check if it overflows
            if (reverse > Integer.MAX_VALUE  || reverse < Integer.MIN_VALUE) {
                return 0;
            }
            n /= 10; // go to the next element
        }
        return (int) reverse;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int x = 1534236469;
        System.out.println(solution.reverse2(x));
    }
}
