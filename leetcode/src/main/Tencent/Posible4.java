package Tencent;

import java.util.Scanner;

public class Posible4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String line = sc.nextLine();
        int k = sc.nextInt();
        sc.nextLine();
        int res = 0;
        for (int i = 0; i < k; i++) {
            String str = sc.nextLine();
            if(solve(str, line, n)) res += 1;
        }
        System.out.println(res);
    }

    private static boolean solve(String str, String line, int n) {
        int len = str.length();
        int lineLen = line.length();
        int lastLen = lineLen%len;
        String t = line.substring(lineLen - lastLen);
        if (lastLen!=0&&!str.startsWith(t)) return false;
        for (int i = 0; i*len < lineLen; i++) {
            for (int j = 0; j < len && i * len + j < lineLen; j++) {
                if (line.charAt(i * len + j) != str.charAt(j)) return false;
            }
        }
        return true;
    }
}
