package ValidBrackets;

import java.util.Stack;

public class ValidBrackets {
    public boolean isValid(String s) {
        if (s.length()==0) return true;
        Stack<Character> brack = new Stack();
        for (char curchar:s.toCharArray()) {
            if (curchar=='{'||curchar=='['||curchar=='(') {
                brack.add(curchar);
            }else if((!brack.isEmpty())&&symmetricChar(curchar)==brack.peek()){
                brack.pop();
            }else {
                return false;
            }
        }
        return brack.isEmpty();
    }

    private char symmetricChar(Character peek) {
        switch (peek) {
            case ']':
                return '[';
            case '}':
                return '{';
            case ')':
                return '(';
            default:
                return peek;
        }
    }

}
