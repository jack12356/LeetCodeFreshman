package LetterCombinations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinations {
    private HashMap<Character,char[]> dic = new HashMap<Character, char[]>(){};
    public List<String> letterCombinations(String digits) {
        dic.put('2',new char[]{'a','b','c'});
        dic.put('3',new char[]{'d','e','f'});
        dic.put('4',new char[]{'g','h','i'});
        dic.put('5',new char[]{'j','k','l'});
        dic.put('6',new char[]{'m','n','o'});
        dic.put('7',new char[]{'p','q','r','s'});
        dic.put('8',new char[]{'t','u','v'});
        dic.put('9',new char[]{'w','x','y','z'});
        List<String> pre_cur = new ArrayList<>();
        if (digits.length()==0) return pre_cur;
        pre_cur.add("");
        for (char digit:digits.toCharArray()) {
            List<String> cur = new ArrayList<>();
            for (String ts:pre_cur) {
                for (char c: dic.get(digit)) {
                    cur.add(ts+ c);
                }
            }
            pre_cur = cur;
        }
        return pre_cur;
    }

    public static void main(String[] args) {
        LetterCombinations su = new LetterCombinations();
        System.out.println(su.letterCombinations("23"));
    }
}
