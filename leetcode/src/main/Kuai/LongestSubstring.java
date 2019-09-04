package Kuai;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LongestSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int res = solve(str);
        System.out.println(res);
    }

    private static int solve(String str) {
        Set<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        int res = 0;
        while (j < str.length()) {
            char tj = str.charAt(j);
            while (i<=j&&set.contains(tj)){
                set.remove(str.charAt(i));
                i++;
            }
            set.add(tj);
            res = Math.max(res, set.size());
            j++;
        }
        return res;
    }
}
