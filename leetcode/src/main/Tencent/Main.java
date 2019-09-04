
import java.util.*;

class Mater{
    int num;
    int w;
    public Mater(int x,int y){
        num = x;
        w = y;
    }
}

public class Main{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] cur_nums = new int[n];
        for (int i = 0; i < n; i++) {
            cur_nums[i] = sc.nextInt();
        }
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }
        Mater[] boxs = new Mater[n];
        for (int i = 0; i < n; i++) {
            boxs[i] = new Mater(cur_nums[i], w[i]);
        }
        Main test = new Main();
        int res = test.solve(n, m, boxs);
        System.out.println(res);

    }

    private int solve(int n, int m, Mater[] boxs) {
        Arrays.sort(boxs,Comparator.comparingInt(o -> o.num));
        int cnt = 0;
        cnt += boxs[0].num;
        while (m >= 0 && boxs[0].num < boxs[n - 1].num) {
            int j = 0;
            for (j = 0; j < n; j++) {
                if (boxs[0].num<boxs[j].num) break;
            }
            if(j>=n) break;

            int i = 0;
            while (i < j && m >= 0) {
                m -= boxs[i].w;
                boxs[i].num += 1;
                i++;
            }
            if(m<0) break;
            else cnt++;
        }
        return cnt;
    }
}