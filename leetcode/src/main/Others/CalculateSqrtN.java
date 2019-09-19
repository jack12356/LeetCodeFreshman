package Others;

import java.util.Scanner;

public class CalculateSqrtN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float a = sc.nextFloat();
        int b = sc.nextInt();
        solve(a, b);
    }

    private static void solve(float a, int b) {
        double st = 0F;
        double end = a;
        while (end-st>0.0000001){
            double mid = st + (end - st) / 2F;
            if(Math.pow(mid,b)>a){
                end = mid;
            }else {
                st = mid;
            }
        }
        System.out.printf("%.6f",st);
    }
}
