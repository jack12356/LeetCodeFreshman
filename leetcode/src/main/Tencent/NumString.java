package Tencent;

import java.util.Scanner;
import java.util.Stack;

public class NumString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String res = getTimesOfString(str);
        System.out.println(res);
    }

    private static String getTimesOfString(String str) {
        if(str==null||str.length()==0) return "";
        char []chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (c == ']') {
                Stack<Character> chStack = new Stack<>();
                while (stack.peek() != '[') {
                    chStack.add(stack.pop());
                }
                stack.pop();// drop '['
                int k = 0;
                while (chStack.peek() != '|') {
                    k = k * 10 + (chStack.pop() - '0');
                }
                chStack.pop();
                StringBuilder t = new StringBuilder();
                while (!chStack.isEmpty()) {
                    t.append(chStack.pop());
                }

                for (int j = 0; j < k; j++) {
                    for (int l = 0; l < t.length(); l++) {
                        stack.add(t.charAt(l));
                    }
                }
            } else {
                stack.add(c);
            }
        }
        return stack.toString();
    }
}

