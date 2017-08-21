package LongestSubstring3;

import java.util.HashSet;
import java.util.Set;

/**
Given a string, find the length of the longest substring without repeating characters.
Examples:
Given "abcabcbb", the answer is "abc", which the length is 3.
Given "bbbbb", the answer is "b", with the length of 1.
Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        //"asjhknafkssdfjhdfsvniosdjfklmsdvops"

        int length = 0;
        if(s.length() == 1){
            return 1;
        }
        for (int i = 0; i < s.length() - length; i++) {
            Set substring = new HashSet();
            substring.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                if (substring.contains(s.charAt(j))) {
                    length=(substring.size()>length)?substring.size():length;
                    break;
                }
                else{
                    substring.add(s.charAt(j));
                    length=(substring.size()>length)?substring.size():length;
                }
            }
        }
        return length;
    }
}
