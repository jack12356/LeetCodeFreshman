package GenerateParentheses22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
  For example, given n = 3, a solution set is:
  [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]
 */
public class Generate {
	public List<String> generateParenthesis(int n) {
		Stack s = new Stack();
		if (n==0) {return null;}
		List<String> rst = new ArrayList<>();
		char l = '(';   char r = ')';
		
		for (int i = 1; i <= 2*n-1; i= 2 + i) {
			List<String> st1= generateParenthesis(((i + 1) / 2) - 1);
			List<String> st2= generateParenthesis((2*n-1-i)/2);
			if (st1!=null&&st2!=null)	{
				for (int j = 0; j < st1.size(); j++) {
					for (int k = 0; k < st2.size(); k++) {
						rst.add(String.valueOf(l) + st1.get(j) + String .valueOf(r) + st2.get(k));
					}
				}
			} else if (st1 == null&&st2!=null) {
				for (int k = 0; k < st2.size(); k++) {
					rst.add(String.valueOf(l) +  String.valueOf(r) + st2.get(k));
				}
			} else if (st1 == null && st2 == null) {
				rst.add(String.valueOf(l)+String .valueOf(r));
			} else {
				for (int j = 0; j < st1.size(); j++) {
					rst.add(String.valueOf(l) + st1.get(j) + String.valueOf(r));
				}
			}
		}
		return rst;
	}
	
	public static void main(String[] args) {
		Generate generate = new Generate();
		List<String > strings = generate.generateParenthesis(3);
		for (String s:strings) {
			System.out.println(s);
		}
	}
}
