import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MoveChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int res = get_num(str);
        System.out.println(res);
    }

    private static int get_num(String str) {
        Set<String> set = new HashSet<>();
        if(str.length()<1) return 0;
        if(str.length()==1) return 1;
        int cnt = 1;
        set.add(str);
        while (true) {
            String next = str.substring(1) + str.charAt(0);
            if (set.contains(next)) {
                break;
            } else {
                set.add(next);
                str = next;
                cnt++;
            }
        }
        return cnt;
    }
}
