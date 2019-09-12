package Alibaba;

import java.util.HashMap;
import java.util.Map;

/*
1. pattern = "abba", str="北京 杭州 杭州 北京" 返回 ture
2. pattern = "aabb", str="北京 杭州 杭州 北京" 返回 false
3. pattern = "baab", str="北京 杭州 杭州 北京" 返回 ture
 */

public class Regex {
    public static void main(String[] args) {
        String str = "北京 杭州 杭州 北京";
        String pattern = "baab";
        System.out.println(wordPattern(pattern,str));
    }

    public static boolean wordPattern(String pattern, String str) {
        if(str==null || pattern==null) return false;
        String []strs = str.split(" ");
        char []chars = pattern.toCharArray();
        if(chars.length!=strs.length) return false;
        Map<String,Character> sTop = new HashMap<>();
        Map<Character,String> pTos = new HashMap<>();
        for(int i = 0;i<chars.length;i++){
            String curS = strs[i];
            char curC = chars[i];
            if(!pTos.containsKey(curC)&&!sTop.containsKey(curS)){
                sTop.put(curS,curC);
                pTos.put(curC,curS);
            }else if(pTos.containsKey(curC)&&sTop.containsKey(curS)){
                if(sTop.get(curS)!=curC||!pTos.get(curC).equals(curS))
                    return false;
            }else{
                return false;
            }
        }
        return true;
    }
}