package LengthOfLongestSubstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring_2(String s) {
        int n = s.length();
        int res = 0;
        int end=0,start=0;
        HashSet<Character> set=new HashSet<>();
        while(start<n && end<n){
            if(set.contains(s.charAt(end))){
                set.remove(s.charAt(start++));
            }else{
                set.add(s.charAt(end++));
                res=Math.max(res,end-start);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring solution = new LengthOfLongestSubstring();
        System.out.println(solution.lengthOfLongestSubstring_2("abba"));
    }
}
