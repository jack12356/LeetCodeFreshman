package GenerateParenthesis;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        parenthesis("", n, n);
        System.out.println(res.toString());
        return res;
    }

    private void parenthesis(String s, int left, int right) {
        if (left==0&&right==0){
            res.add(s);
            return;
        }
        if (left>0) parenthesis(s+'(',left-1,right);
        if (right>left) parenthesis(s+')',left,right-1);
    }

    public static void main(String[] args) {
        GenerateParenthesis su = new GenerateParenthesis();
        su.generateParenthesis(3);
    }
}
