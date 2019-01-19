import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Trie{
    String word;
    HashMap<Character,Trie> map = new HashMap<>();

    Trie buildTrie(List<String> words){
        Trie root = new Trie();
        for (String word:words) {
            Trie cur = root;
            for (char c:word.toCharArray()) {
                if (!cur.map.containsKey(c))
                    cur.map.put(c, new Trie());
                cur = cur.map.get(c);
            }
            cur.word = word;
        }
        return root;
    }
}