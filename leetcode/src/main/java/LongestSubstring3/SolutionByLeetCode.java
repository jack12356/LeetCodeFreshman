package LongestSubstring3;

import java.util.HashMap;
import java.util.Map;

public class SolutionByLeetCode {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        HashMap<Character,Integer> map = new  HashMap<Character,Integer>();
        for (int i = 0,j=0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j))+1, i);
            }
            ans =Math.max(ans,(j - i + 1));
            map.put(s.charAt(j), j);
        }
        return ans;
    }
}