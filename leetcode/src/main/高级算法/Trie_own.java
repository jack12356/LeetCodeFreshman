import java.util.HashMap;
import java.util.List;

class Trie_own {
    String word;
    HashMap<Character, Trie_own> map = new HashMap<>();

    Trie_own buildTrie(List<String> words){
        Trie_own root = new Trie_own();
        for (String word:words) {
            Trie_own cur = root;
            for (char c:word.toCharArray()) {
                if (!cur.map.containsKey(c))
                    cur.map.put(c, new Trie_own());
                cur = cur.map.get(c);
            }
            cur.word = word;
        }
        return root;
    }
}