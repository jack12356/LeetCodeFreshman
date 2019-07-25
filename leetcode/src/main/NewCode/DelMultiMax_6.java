import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DelMultiMax_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solve(n));
    }

    private static int solve(int n) {
        String str = String.valueOf(n);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i) - '0');
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (list.get(i) == list.get(j)) {
                    if (list.get(j) < list.get(j + 1)) {
                        list.remove(j);
                        i--;
                        break;
                    }else {
                        list.remove(i);
                        i--;
                        break;
                    }
                }
            }
        }
        int res = 0;
        for (Integer integer : list) {
            res = res * 10 + integer;
        }
        return res;
    }
}
