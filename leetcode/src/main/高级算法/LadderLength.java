
import java.util.*;

public class LadderLength {
    public int ladderLength_2(String beginWord, String endWord, List<String> wordList) {
        LinkedList<String> queue = new LinkedList<>();
        HashMap<String,Integer> map = new HashMap<>();
        queue.add(beginWord);
        map.put(beginWord, 1);
        while (!queue.isEmpty()){
            String levelword = queue.poll();
            Iterator<String> it = wordList.iterator();
            while (it.hasNext()){
                String word = it.next();
                if (word.equals(levelword)) {
                    it.remove();
                    continue;
                }
                //看能否转换
                if(canTrans(levelword,word)){
                    queue.add(word);
                    it.remove();
                    map.put(word, map.get(levelword) + 1);
                    if (word.equals(endWord)) return map.get(levelword) + 1;
                }
            }

        }
        return 0;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        LinkedList<String> queue = new LinkedList<String>();
        HashMap<String, Integer> map = new HashMap<>();
        queue.add(beginWord);
        map.put(beginWord, 1);
        while (!queue.isEmpty()){
            String levelWord = queue.poll();
            Iterator it = wordList.iterator();
            while (it.hasNext()){
                 String word = (String) it.next();
                 if(word.equals(levelWord)){
                     it.remove();
                     continue;
                 }
                 if (canTrans(levelWord,word)){
                     if (word.equals(endWord)) return map.get(levelWord)+1;
                     queue.add(word);
                     map.put(word,map.get(levelWord)+1);
                     it.remove();
                 }
            }

        }
        return 0;
    }

    private boolean canTrans(String levelword, String word) {
        int count = 0;
        for (int i = 0; i < levelword.length(); i++) {
            if (levelword.charAt(i)!=word.charAt(i)) count++;
            if (count>1) return false;
        }
        return true;
    }


    public static void main(String[] args) {
       String beginword =  "hit";
       String endword = "cog";
       List<String> lists = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
       LadderLength su = new LadderLength();
        System.out.println(su.ladderLength(beginword, endword, lists));
    }
}
