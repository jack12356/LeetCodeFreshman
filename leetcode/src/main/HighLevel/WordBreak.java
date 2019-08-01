import java.util.*;

public class WordBreak {
    public boolean wordBreak_digui(String s, List<String> wordDict) {
        if (s.length()==0) return false;
        for (String word : wordDict){
            if (s.startsWith(word)&&(s.length()==word.length()||wordBreak_digui(s.substring(word.length()),wordDict))) return true;
        }
        return false;
    }
    public boolean canwordBreak(String s, List<String> wordDict) {
        if (s.length()==0||wordDict.isEmpty()) return false;
        boolean []dp = new boolean[s.length()];
        for (int i = 0; i < dp.length; i++) {
            String curStr = s.substring(0,i+1);
            for (String word : wordDict){
                if (curStr.endsWith(word) && (curStr.length() == word.length() || dp[i - word.length()])) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()-1];
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (!canwordBreak(s,wordDict)) return new ArrayList<>();
        List<String>[] dp = new List[s.length()];
        for (int i = 0; i < dp.length; i++) {
            String curStr = s.substring(0,i+1);
            dp[i] = new ArrayList<>();
            for (String word : wordDict){
                if (curStr.endsWith(word)) {
                    if (curStr.length()==word.length()) dp[i].add(word);                //如果长度相等
                    else for (String str:dp[i-word.length()]) dp[i].add(str + " " + word);  //如果前面的不为空，就挨个添加结果
                }
            }
        }
        return dp[s.length()-1];
    }
}
