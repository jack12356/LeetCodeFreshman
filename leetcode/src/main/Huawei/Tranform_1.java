package Huawei;

import java.util.*;

public class Tranform_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String []strs = line.split(" ");
        solve(strs);
    }

    private static void solve(String[] strs) {
        if (strs.length==0) return;
        Deque<String> deque = new LinkedList<>();
        for (int i = 1; i < strs.length; i++) {
            String s = strs[i];
            if(s.equals(" ")) continue;
            if (s.equals("A")) {
                deque.add("12");
                deque.add("34");
            } else if (s.equals("B")) {
                deque.add("AB");
                deque.add("CD");
            } else {
                deque.add(s);
            }
        }

        deque.addFirst(Integer.toHexString(deque.size() + 1).toUpperCase());
        while (!deque.isEmpty()){
            System.out.print(deque.pollFirst());
            System.out.print(" ");
        }
    }
}
