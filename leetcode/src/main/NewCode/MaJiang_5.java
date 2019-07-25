import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MaJiang_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> cards = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            cards.add(sc.nextInt());
        }
        for (int i = 1; i < 10; i++) {
            List<Integer> new_cards = new ArrayList<>(cards);
            new_cards.add(i);
            Collections.sort(new_cards);
            if (is_hu(new_cards)) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }

    private static boolean is_hu(List<Integer> cards) {
        int len = cards.size();
        if(len==0) return true;
        if(len==1) return false;
        if (len == 2 && cards.get(0) == cards.get(1)) {
            return true;
        }
        if(len<3) return false;
        for (int i = 0; i < len; i++) {
            if(i<len-4&& cards.get(i).equals(cards.get(i + 4)))
                return false;
        }
        int c0 = cards.get(0);
        if(c0==cards.get(1)){
            List<Integer> new_cards = new ArrayList<>(cards);
            new_cards.remove(0);
            new_cards.remove(1);
            if(is_hu(new_cards)) return true;
        }
        if(c0==cards.get(1)&&c0==cards.get(2)){
            List<Integer> new_cards = new ArrayList<>(cards);
            new_cards.remove(0);
            new_cards.remove(0);
            new_cards.remove(0);
            if(is_hu(new_cards)) return true;
        }
        if(cards.contains(c0+1)&&cards.contains(c0+2)){
            List<Integer> new_cards = new ArrayList<>(cards);
            new_cards.remove(Integer.valueOf(c0));
            new_cards.remove(Integer.valueOf(c0+1));
            new_cards.remove(Integer.valueOf(c0+2));
            return is_hu(new_cards);
        }
        return false;
    }
}
