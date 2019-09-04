package Others;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayString {
    public static void main(String[] args) {
        String []strs = new String []{"1","13","12","23","462","37"};
        String res = arrayString(strs);
        System.out.println(res);
    }

    private static String arrayString(String[] strs) {
        StringBuilder res = new StringBuilder();
        Comparator<String> comparator = (s1, s2) -> Integer.parseInt(s2+s1)-Integer.parseInt(s1+s2);
        Arrays.sort(strs,comparator);
        for (String s :
                strs) {
            res.append(s);
        }
        return res.toString();
    }

}
