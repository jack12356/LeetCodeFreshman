package LetterCombinationsofaPhoneNumber17;

import java.util.*;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below.
 Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 Note:
 Although the above answer is in lexicographical order, your answer could be in any order you want.
 */

public class Solution {
//    Map<Integer,String> digitMap = new HashMap<>();
//        digitMap.put(2, "abc");
//        digitMap.put(3, "def");
//        digitMap.put(4, "ghi");
//        digitMap.put(5, "jkl");
//        digitMap.put(6, "mno");
//        digitMap.put(7, "pqrs");
//        digitMap.put(8, "tuv");
//        digitMap.put(9, "wxyz");
    private static String[] letters = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        int len = digits.length();
        if (len==0) return list;
        String s = letters[digits.charAt(0) - '0'];
        for (int i = 0; i < s.length(); i++) {
            List subStrings = letterCombinations(digits.substring(1));
            if (subStrings.size()==0) {list.add(String.valueOf(s.charAt(i)));continue;}
            for (Object s1: subStrings) {
                list.add(String.valueOf(s.charAt(i)) + s1.toString());//reuse of method
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List list = solution.letterCombinations("326");
        for (Object s:list) {
            System.out.print(s+" ");
        }
    }
}
