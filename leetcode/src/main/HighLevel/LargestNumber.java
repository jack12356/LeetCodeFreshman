import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public Comparator<String> comparater =  new Comparator<String>() {
        @Override
        public int compare(String s1, String s2) {
            if (s1.length()==0) return s2.length();
            if (s2.length()==0) return s1.length();
            int i=0,j=0;
            while (i<s1.length()&&j<s2.length()&&s1.charAt(i)==s2.charAt(j)){
                i++;
                j++;
            }
            if (i==s1.length()&&j==s2.length()) return 0;
            if (i==s1.length()||j==s2.length()){
                String n_str1 = s1.concat(s2);
                String n_str2 = s2.concat(s1);
                return compare(n_str1, n_str2);
            }
            return s1.charAt(i)-s2.charAt(j);
        }
    };

    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs,comparater);
        StringBuilder res = new StringBuilder();
        if (strs[strs.length - 1].equals("0")) return "0";
        for (int i = strs.length - 1; i >= 0; i--) res.append(strs[i]);
        return res.toString();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 30,31, 34, 5, 9};
        System.out.println(new LargestNumber().largestNumber(nums));
    }
}
