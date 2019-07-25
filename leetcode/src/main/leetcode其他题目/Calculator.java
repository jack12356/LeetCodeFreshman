import com.sun.org.apache.xerces.internal.xs.StringList;

import java.lang.reflect.Array;
import java.util.*;

public class Calculator {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String line = sc.nextLine();
//        int res = solve(line);
//        System.out.println(res);
//    }

    public static void main(String[] args) {
        String a = " a  b  c";
        String []strs0 = a.split(" ");
        List<String> list = new ArrayList<>(Arrays.asList(strs0));
//        for (int i = list.size()-1; i >=0; i--) {
//            if(list.get(i).equals("")) list.remove(i);
//        }
        list.removeAll(Arrays.asList(""));
        String []strs = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            strs[i] = list.get(i);
        }
        for (String s:strs) {
            System.out.println(s);
        }
    }

    private static int solve(String line) {
        line = line.replaceAll("\\+", " + ");
        line = line.replaceAll("-", " - ");
        line = line.replaceAll("\\*", " * ");
        line = line.replaceAll("/", " / ");
        String []strs0 = line.split(" ");
        List<String> list = new ArrayList<>();
        for (String s:strs0) {
            if(s.equals("")) continue;
            list.add(s);
        }
        String []strs = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            strs[i] = list.get(i);
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < strs.length; i++) {
            String cur = strs[i];
            if (cur.equals("") || cur.equals(" ")) continue;
            if (cur.equals("+")) {
                i++;
                stack.push(Integer.valueOf(strs[i]));
                continue;
            }
            if(cur.equals("-")){
                i++;
                stack.push(-Integer.valueOf(strs[i]));
                continue;
            }
            if (cur.equals("*")) {
                int pre = stack.pop();
                i++;
                int t = pre * Integer.valueOf(strs[i]);
                stack.push(t);
                continue;
            }
            if (cur.equals("/")) {
                int pre = stack.pop();
                i++;
                int t = pre / Integer.valueOf(strs[i]);
                stack.push(t);
                continue;
            }
            stack.push(Integer.valueOf(cur));
        }
        int res = 0;
        while (!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
}
