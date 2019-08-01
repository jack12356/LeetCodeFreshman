import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Com {
    int diff;
    int i;
    Com(int x , int y){
        diff = x;
        i = y;
    }
}

public class WarWorld_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];
        for (int i = 0; i < n; i++) A[i] = sc.nextInt();
        for (int i = 0; i < n; i++) B[i] = sc.nextInt();
        sc.close();
        int res = solve(A, B);
        System.out.println(res);
    }

    private static int solve(int[] a, int[] b) {
        Com[] c = new Com[a.length];
        for (int i = 0; i < a.length; i++) {
            int diff = a[i]-b[i];
            c[i] = new Com(diff, i);
        }
        Arrays.sort(c, Comparator.comparingInt(o -> o.diff));
        int n = a.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (i < n / 3) {
                res += b[c[i].i];
            } else if (i < (2 * n / 3)) {
                res += (a[c[i].i] + b[c[i].i]) / 2;
            } else {
                res += a[c[i].i];
            }
        }
        return res;
    }
}
