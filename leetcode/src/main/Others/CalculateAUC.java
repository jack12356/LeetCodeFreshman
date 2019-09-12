package Others;

import java.util.Arrays;
import java.util.Comparator;

class Zip{
    float rank;
    int lable;
    float pre;
    Zip(int y, float z){
        lable = y;
        pre = z;
    }
}
public class CalculateAUC {
    public static void main(String[] args) {
        int[] t = new int[]{1, 0, 0, 0, 1, 0, 1, 0};
        float[] p = new float[]{0.1F, 0.05F, 0.4F, 0.7F, 0.2F, 0.34F, 0.8F, 0.87F};
        float auc = getAuc(t, p);
        System.out.printf("%.5f",auc);
    }


    private static float getAuc(int[] t, float[] p) {
        Zip[] zips = new Zip[t.length];
        for (int i = 0; i < t.length; i++) {
            zips[i] = new Zip(t[i], p[i]);
        }
        Arrays.sort(zips, Comparator.comparingDouble(o1 -> o1.pre));
        for (int i = 0; i < t.length; i++) {
            zips[i].rank = (float) (i + 1);
        }
        // calculate auc
        float sum = 0;
        float M = 0;
        for (int i = 0; i < t.length; i++) {
            Zip cur = zips[i];
            sum += cur.lable == 1 ? cur.rank : 0;
            M += cur.lable;
        }
        float N = t.length - M;
        return ((sum-(M*(M+1)/2))/(M*N));
    }
}
