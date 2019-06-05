import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        String str = sc.nextLine();
        ReverseString test = new ReverseString();
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        System.out.println(test.getRes(str,map));
    }

    private String getRes(String str,Map<Character,Character> map) {
        Stack<Character> stack = new Stack<>();
        char []chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Character c = chars[i];
            // 遇到反括号，就回退到对应括号为止，并且做乘法后，将结果存回stack，保证每次操作反括号时，这个括号里面始终是字符串
            // 如 2{ab3[c]} ==> 2{abccc} ==> abcccabccc
            if (map.containsKey(c)){
                StringBuilder stb = new StringBuilder();
                while (!stack.empty()&&stack.peek()!=map.get(c)){
                    stb.append(stack.pop());
                }
                stack.pop();
                int n = stack.pop()-'0';
                if(n==0) stb=new StringBuilder();
                else {
                    String t = stb.toString();
                    for (int j = 0; j < n-1; j++) stb.append(t);
                }
                for(int j=stb.length()-1;j>=0;j--) stack.add(stb.charAt(j));
            }
            else stack.add(c);                              //正常情况
        }
        // 将stack反序输出
        StringBuilder res = new StringBuilder();
        while (!stack.empty()) res.append(stack.pop());
        return res.toString();
    }
}
