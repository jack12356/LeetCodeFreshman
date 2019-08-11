package PinDuoDuo;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Box{
    int len;
    int weight;
}

public class JiMu4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Box[] boxs = new Box[n];
        for (int i = 0; i < n; i++) {
            boxs[i] = new Box();
            boxs[i].len = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            boxs[i].weight = sc.nextInt();
        }
        int max_floors = solve(boxs);
        System.out.println(max_floors);
    }

    private static int solve(Box[] boxs) {
        Arrays.sort(boxs, Comparator.comparingInt(o1 -> o1.len));
        int[] floors = new int[boxs.length];        // max floors on current box;
        int[] weights = new int[boxs.length];       // weights on current box;
        floors[0] = 1;
        weights[0] = 0;
        for (int i = 0; i < boxs.length; i++) {
            int min_w = Integer.MAX_VALUE;
            int max_f = 0;
            for (int j = 0; j < i; j++) {
                if(weights[j]<boxs[i].weight*7||floors[j]>max_f||(floors[j]==max_f&&weights[j]<min_w)){
                    min_w = weights[j];
                    max_f = floors[j];
                }
            }
            weights[i] = min_w + boxs[i].weight;
            floors[i] = max_f + 1;
        }
        return floors[boxs.length-1];
    }
}
