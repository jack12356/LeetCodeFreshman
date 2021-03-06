package Others;

import java.util.ArrayList;
import java.util.List;

public class ZuHe {
    public static void main(String[] args) {
        ZuHe test = new ZuHe();
        String s = "abcd";
        List<String> res = new ArrayList<>();
        test.getM(s,"",3,res);
        for(String cur:res) System.out.println(cur);
    }

    private void getM(String s,String state,int m,List<String> res) {
        if(s.length()<m) return;
        if(m==0) {
            res.add(state);
            return;
        }
        String substring = s.substring(1);
        getM(substring,state+s.charAt(0),m-1,res);
        getM(substring,state,m,res);
    }
}
