package StringAndList;

import java.util.Arrays;
import java.util.Scanner;

public class MaxString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String res = solve(line);
        System.out.println(res);
    }

    private static String solve(String line) {
        if(line==null||line.length()==0) return "0";
        String []strs = line.split(",");
        Arrays.sort(strs, (s1, s2) -> (s2+s1).compareTo(s1+s2));
        StringBuilder stb = new StringBuilder();
        if(strs[0].equals("0")) return "0";
        for (int i = 0; i < strs.length; i++) {
            stb.append(strs[i]);
        }
        return stb.toString();
    }
}
