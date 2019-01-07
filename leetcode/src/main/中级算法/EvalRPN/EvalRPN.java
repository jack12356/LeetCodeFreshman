package EvalRPN;

import java.util.Stack;

public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s:tokens) {
            if (s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")){
                int last = stack.pop();
                int forward = stack.pop();
                stack.push(exeCulculate(forward,last,s));
            }
            else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }

    private int exeCulculate(int temp, int cur_res, String s) {
        switch (s) {
            case "+" : return temp + cur_res;
            case "-": return temp - cur_res;
            case "*": return temp*cur_res;
            case "/": return temp/cur_res;
            default: return -1;
        }
    }

    public static void main(String[] args) {
        EvalRPN su = new EvalRPN();
        String[] tokens = new String[]{"4", "13", "5", "/", "+"};
        System.out.println(su.evalRPN(tokens));
    }
}
