package CommonStr;

public class CommonStr {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        String common = "";
        if (n==0)
            return common;
        for (int j = 0; j < strs[0].length(); j++) {
            int i =1;
            char c0 = strs[0].charAt(j);
            for (; i < n; i++) {   //i表示字符串数
                if(j==strs[i].length()||strs[i].charAt(j)!=c0){
                    return common;
                }
            }
            common+=c0;
        }
        return common;
    }

    public static void main(String[] args) {
        String []strs = {"flower","flow","flight"};
        CommonStr solution = new CommonStr();
        System.out.println(solution.longestCommonPrefix(strs));
    }
}
