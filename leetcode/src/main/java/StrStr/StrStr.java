package StrStr;

public class StrStr {
    public int strStr(String haystack, String needle) {
        int lenh = haystack.length();
        int lenn = needle.length();
        if(needle.isEmpty())
            return 0;
        char n0 = needle.charAt(0);
        for (int i = 0; i < lenh-lenn+1; i++) {
            char h0 = haystack.charAt(i);
            if(h0==n0){
                int j=0;
                while(haystack.charAt(i+j)==needle.charAt(j)){
                    j++;
                    if(j==lenn){
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        StrStr solution =  new StrStr();
        String haystack = "gdjhagdj";
        String neelde = "ha";
        System.out.println(solution.strStr(haystack, neelde));
    }
}
