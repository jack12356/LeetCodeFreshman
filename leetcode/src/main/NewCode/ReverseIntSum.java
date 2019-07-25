import java.util.Scanner;

public class ReverseIntSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(solve(a,b));

    }

    private static int solve(int a, int b) {
        StringBuilder a_str = new  StringBuilder(String.valueOf(a));
        StringBuilder b_str = new StringBuilder(String.valueOf(b));
        int carry=0;
        int len = Math.max(a_str.length(), b_str.length());
        while(a_str.length()<len){
            a_str.append('0');
        }
        while(b_str.length()<len){
            b_str.append('0');
        }
        int[] res = new int[len + 1];
        int i =len-1;
        while(i>=0){
            int n = carry + (a_str.charAt(i) - '0') + (b_str.charAt(i) - '0');
            res[i + 1] = n % 10;
            carry = n / 10;
            i--;
        }
        if(carry>0) res[0] = 1;
        int t = 0;
        for (int j = 0; j < len+1; j++) {
            t = t * 10 + res[j];
        }
        return t;
    }
}
