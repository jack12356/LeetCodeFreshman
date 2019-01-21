import java.util.HashMap;

public class Trie {
    String word;
    HashMap<Character,Trie> map = new HashMap<>();
    /** Initialize your data structure here. */
    public Trie() {
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie cur = this;
        for (char c:word.toCharArray()) {
            if (!cur.map.containsKey(c))
                cur.map.put(c, new Trie());
            cur = cur.map.get(c);
        }
        cur.word = word;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie cur = this;
        for (char c:word.toCharArray()) {
            if (!cur.map.containsKey(c))
                return false;
            cur = cur.map.get(c);
        }
        return !(cur.word==null);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String word) {
        Trie cur = this;
        for (char c:word.toCharArray()) {
            if (!cur.map.containsKey(c))
                return false;
            cur = cur.map.get(c);
        }
        return true;
    }

    public static void main(String[] args) {
        Trie obj = new Trie();
        String word = "abcde";
        String prefix = "abc";
        obj.insert(word);
        boolean param_2 = obj.search(word);
        boolean param_3 = obj.startsWith(prefix);
    }
}


