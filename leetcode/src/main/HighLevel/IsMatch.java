import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class IsMatch {
    public char sinChar = '?';
    public char strChar = '*';
    SuffixTree tree;
    class SuffixTree{
        HashMap<Character, List<Integer>> map = new HashMap<>();
        SuffixTree build(String word){
            SuffixTree root = this;
            for (int i = 0;i<word.length();i++) {
                char c = word.charAt(i);
                if (!map.containsKey(c)) map.put(c, Arrays.asList(i));
                else map.get(c).add(i);
            }
            return root;
        }
    }
    public boolean isMatch(String s, String p) {
        if (s.equals("")) return p.equals("*")||p.equals("");
        if (p.equals("")) return false;
        tree = tree.build(s);
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (dfs(s,c,i)) return true;
        }
        return false;
    }

    private boolean dfs(String s, char c, int i) {
        char curChar = s.charAt(i);
        if (curChar!=c) return false;

        return false;
    }
}
