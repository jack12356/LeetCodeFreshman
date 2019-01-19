import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Partition {
    public List<List<String>> partition(String s) {
        List<List<String>> res= new ArrayList<>();
        if (s.length()==0) return res;
        List<String> allPalindrome =  findAllFirstPalindrome(s);  //找到所有开头的回文串
        for (String palindrome:allPalindrome) {
            List<List<String>> nextLists;
            if (s.length()>palindrome.length()) {
                nextLists = partition(s.substring(palindrome.length()));   //后面的所有回文串组合
                for (List<String> list : nextLists){
                    list.add(0, palindrome);
                }
                res.addAll(nextLists);
            }else res.add(new ArrayList<String>(Collections.singletonList(palindrome)));
        }
        return res;
    }

    private List<String> findAllFirstPalindrome(String s) {
        List<String> allPalindrome = new ArrayList<>();
        char c = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==c){
                int st = 0;
                int end = i;
                while (st<end){
                    if (s.charAt(end) == s.charAt(st)) {
                        end--;
                        st++;
                    }else break;
                }
                if(st>=end) allPalindrome.add(s.substring(0, i + 1));
            }
        }
        return allPalindrome;
    }
}
