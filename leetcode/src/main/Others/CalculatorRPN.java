package Others;

import java.util.Scanner;
import java.util.Stack;

public class CalculatorRPN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strs = sc.nextLine();
        String []tokens = strs.split(" ");
        CalculatorRPN test = new CalculatorRPN();
        int res = test.evalRPN(tokens);
        System.out.println(res);
    }

    private int evalRPN(String[] tokens) {
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
}
