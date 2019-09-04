package leetcode其他题目;

import java.util.Scanner;

public class GotMaxSumInMNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[m];
        int[] b = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }
        getMaxMNum(a,b,n,m);
    }

    private static void getMaxMNum(int[] a, int[] b, int n, int m) {
        StringBuilder res = new StringBuilder();
        for (int curSum = m-1; curSum >=0 ; curSum--) {
            for (int aIndex = 0; aIndex < m - 1; aIndex++) {
                int bIndex = (curSum - aIndex + m) % m;
                int cnt = Math.min(a[aIndex],b[bIndex]);
                for (int i = 0; i < cnt; i++) {
                    res.append(curSum);
                }
                a[aIndex] -= cnt;
                b[bIndex] -= cnt;
            }
            if(res.length()==n) break;
        }
        System.out.println(res.toString());
    }
}
