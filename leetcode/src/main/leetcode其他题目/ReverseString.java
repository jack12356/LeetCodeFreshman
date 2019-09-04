package leetcode其他题目;

import java.util.Stack;

public class ReverseString {
    public String reverseWords(String s) {
        String []strs = s.split(" ");
        Stack<String> stack = new Stack<>();
        for (String str : strs) {
            if (!str.equals("")) {
                stack.add(reverse(str));
            }
        }
        StringBuilder stb = new StringBuilder();
        while(!stack.isEmpty()){
            stb.append(stack.pop());
        }
        return stb.toString();
    }

    private String reverse(String str) {
        char []c = str.toCharArray();
        int st = 0;
        int end = c.length-1;
        while (st<=end){
            char t = c[st];
            c[st] = c[end];
            c[end] = t;
            st++;
            end--;
        }
        return String.valueOf(c);
    }

}
