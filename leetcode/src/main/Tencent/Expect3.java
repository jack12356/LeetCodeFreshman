package Tencent;

import java.util.Scanner;

public class Expect3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        solve(n, p, q);
    }

    private static void solve(int n, int p, int q) {
        double rmin = 0;
        double rsum = 0;
        for (int i = p; i+q <= n; i++) {
            int r1 = getZuHe(n, i);
//            int r2 = getZuHe(n - i, q);
            rmin += r1  * i;
            rsum += r1;
        }
        if(rmin%rsum==0) System.out.println(rmin/rsum);
        else System.out.println(rmin/rsum);
    }

    private  static  int getZuHe(int n,int k){
        if(k>n/2) k = n-k;
        int r = 1;
        for (int i = n; i >= n-k+1 ; i--) {
            r *= i;
        }
        for (int i = 1; i <= k; i++) {
            r /= i;
        }
        return r;
    }
}
