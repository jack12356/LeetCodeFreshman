package Tencent;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Insert2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int k = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < t; i++) {
            int st = sc.nextInt();
            int end = sc.nextInt();
            solve(st,end,k,map);
        }
        sc.close();
    }

    private static void solve(int st, int end, int k, Map<Integer, Integer> map) {
        int res = 0;
        for (int i = st; i <= end; i++) {
            res += getZuHe(k, i, map);
        }
        System.out.println(res);
    }

    private static int getZuHe(int k, int len, Map<Integer,Integer> map) {
        if(map.containsKey(len)) {
            return map.get(len);
        }
        int res = 0;
        for (int cnt = 0; cnt*k <= len; cnt++) {
            int n = len - cnt * k + cnt;
            if(cnt>n/2) cnt = n - cnt;
            int r = 1;
            for (int i = n; i >= n-cnt+1 ; i--) {
                r *= i;
            }
            for (int i = 1; i <= cnt; i++) {
                r /= i;
            }
            res += r;
        }
        map.put(len, res);
        return res;
    }
}
