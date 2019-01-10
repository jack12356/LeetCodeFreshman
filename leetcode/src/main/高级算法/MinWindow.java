public class MinWindow {
    public static String minWindow(String s, String t) {
        int[] nums = new int[128];
        int count = 0;
        int end = 0;
        int st = 0;
        int min = Integer.MAX_VALUE;
        String res = "";
        for (char c :t.toCharArray()) nums[c]++;
        while (end<s.length()){
            char c_end = s.charAt(end);
            if (nums[c_end] > 0) count++;
            nums[c_end]--;
            while (count == t.length()) {
                if (end - st + 1 < min) {
                    min = end - st + 1;
                    res = s.substring(st, end + 1);
                }
                char c_st = s.charAt(st);
                nums[c_st]++;
                if (nums[c_st] > 0) count--;
                st++;
            }
            end++;
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "ADOBECOVBANC";
        String t = "ABC";
        System.out.println(minWindow(str, t));
    }
}
