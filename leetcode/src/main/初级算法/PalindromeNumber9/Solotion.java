package PalindromeNumber9;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 Some hints:
 Could negative integers be palindromes? (ie, -1)
 If you are thinking of converting the integer to string, note the restriction of using extra space.
 You could also try reversing an integer. However, if you have solved the problem "Reverse Integer",
 you know that the reversed integer might overflow. How would you handle such case?
 There is a more generic way of solving this problem.
 */

public class Solotion {
    public boolean isPalindrome(int x) {
        String st = String.valueOf(x);
        int len = st.length();
        for (int i = 0; i < len/2; i++) {
            if (st.charAt(i)!= st.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(String.valueOf(123456));
    }
}
