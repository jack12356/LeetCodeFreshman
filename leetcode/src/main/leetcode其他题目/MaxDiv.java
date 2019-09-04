package leetcode其他题目;

import java.util.Scanner;

public class MaxDiv {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();
        MaxDiv solve = new MaxDiv();
        int max_div = solve.get_max_div(a);
        int res = 0;
        for (int i = 0; i < a.length; i++) {
            res += (a[i] / max_div);
        }
        System.out.println(res);
    }

    public int get_max_div(int[] a) {
        if(a.length==1){
            return a[0];
        }
        if(a.length==2){
            return gcd(a[0], a[1]);
        }
        int count = 0;
        for (int i = 2; i < a.length; i++) {
            count = gcd(gcd(a[i - 2], a[i - 1]), a[i]);
        }
        return count;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

}


