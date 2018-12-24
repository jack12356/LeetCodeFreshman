package GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        int len = strs.length;
        List<List<String>> res = new ArrayList<>();
        HashMap<int[],List<String>> map = new HashMap<>();
        List<String> curstrs = new ArrayList<>();

        for (int i = 0; i < len; i++) {

            curstrs.add(strs[i]);

            int []nums1 = new int [26];
            for (char c : strs[i].toCharArray()) nums1[c-'a']+=1;
            for (int j = i+1; j < len; j++) {
                boolean isequal = true;
                int []nums2 = nums1.clone();
                for (char c : strs[j].toCharArray()) nums2[c-'a']-=1;
                for (int t:nums2) if (t!=0) {
                    isequal=false;
                    break;
                }
                if(isequal){

                    curstrs.add(strs[j]);
                }
            }
            res.add(curstrs);
        }
        return res;
    }

    public String sort(String s){
        char []chars= s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i+1; j < chars.length;j++) {
                if (chars[i]>chars[j]){
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                }
            }
        }
        return String.valueOf(chars);
    }

    public List<List<String>> groupAnagrams_2(String[] strs) {
        int len = strs.length;
        HashMap<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            String sort_str = sort(str);
            if (map.containsKey(sort_str)) {
                map.get(sort_str).add(str);
            } else map.put(sort_str, new ArrayList<>(Arrays.asList(str)));
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        List<List<String>> ret;
        ret = groupAnagrams.groupAnagrams_2(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(ret);
//        System.out.println(groupAnagrams.sort("atemp"));
    }
}
