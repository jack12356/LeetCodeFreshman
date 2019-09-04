package leetcode其他题目;

public class strStrs {
    public int matchStrStrs(String s1, String s2){
        if(s2==null) return 0;
        if(s1==null) return -1;
        int s20 = s2.charAt(0);
        for (int i = 0; i < s1.length(); i++) {
            if (s20 == s1.charAt(i)) {
                int j = 0;
                while (j<s2.length()&&(i+j<s1.length())&&s2.charAt(j)==s1.charAt(i+j)){
                    j++;
                }
                if(j>=s2.length()) return i;
            }
        }
        return -1;
    }


}
