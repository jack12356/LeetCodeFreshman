import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Lisp_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int res = solve(str);
        if (res == -1) {
            System.out.println("error");
        } else {

            System.out.println(res);
        }
    }

    private static int solve(String str) {
        if(str.length()==0) return 0;
        str = str.replaceAll("\\("," ( ");
        str = str.replaceAll("\\)"," ) ");
        String []strs = str.split(" ");
        Stack<String> stack = new Stack<>();
        for (String cur : strs) {
            if(cur.equals("")) continue;
            if (cur.equals(")")) {
                List<Integer> nums = new ArrayList<>();
                while (!stack.peek().equals("(")) {
                    String t = stack.peek();
                    if (t.equals("add")) {
                        get_add(stack, nums);
                        break;
                    }
                    if (t.equals("div")) {
                        if(nums.get(0)==0) {
                            return -1;
                        }
                        get_div(stack, nums);
                        break;
                    }
                    if (t.equals("mul")) {
                        get_mul(stack, nums);
                        break;
                    }
                    if (t.equals("sub")) {
                        get_sub(stack, nums);
                        break;
                    }
                    nums.add(Integer.valueOf(stack.pop()));
                }
            } else {
                stack.push(cur);
            }
        }
        return Integer.valueOf(stack.pop());
    }

    private static void get_add(Stack<String> stack, List<Integer> nums) {
        int sum = 0;
        for (Integer n :nums) {
            sum += n;
        }
        stack.pop();
        stack.pop();
        stack.push(String.valueOf(sum));
    }
    private static void get_mul(Stack<String> stack, List<Integer> nums) {
        int sum = 1;
        for (Integer n :nums) {
            sum *= n;
        }
        stack.pop();
        stack.pop();
        stack.push(String.valueOf(sum));
    }

    private static void get_div(Stack<String> stack, List<Integer> nums) {
        stack.pop();
        stack.pop();
        stack.push(String.valueOf(nums.get(1)/nums.get(0)));
    }
    private static void get_sub(Stack<String> stack, List<Integer> nums) {
        stack.pop();
        stack.pop();
        stack.push(String.valueOf(nums.get(1)-nums.get(0)));
    }
}
