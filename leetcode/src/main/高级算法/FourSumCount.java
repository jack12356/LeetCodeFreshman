import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FourSumCount {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D){
        int res = 0;
        Arrays.sort(C);
        Arrays.sort(D);
        for (int a :A) {
            for (int b :B) {
                int left=0,rt=A.length-1;
                int aim_sum = -a-b;
                while (left < A.length && rt >= 0) {
                    int cur_sum = C[left] + D[rt];
                    if (cur_sum == aim_sum) {
                        int lcount = 1, rcount = 1;
                        while (left < A.length - 1 && C[left + 1] == C[left]) {
                            left++;
                            lcount++;
                        }
                        while (rt >0 && D[rt - 1] == D[rt]) {
                            rt--;
                            rcount++;
                        }
                        left++;
                        rt--;
                        res += lcount * rcount;
                    } else if (cur_sum > aim_sum) rt--;
                    else left++;
                }
            }
        }
        return res;
    }

    public int fourSumCount_2(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer,Integer> map = new HashMap<>();

        int count = 0;
        for (int a : A) {
            for (int b : B) {
                map.put(a + b, map.getOrDefault(a + b, 0) + 1);
            }
        }

        for (int c : C) {
            for (int d : D) {
                count += map.getOrDefault(-c - d, 0);
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int []A = new int[]{1,2};
        int []B = new int[]{-2,-1};
        int []C = new int[]{-1,2};
        int []D = new int[]{0,2};
        FourSumCount su = new FourSumCount();
        System.out.println(su.fourSumCount(A, B, C, D));
    }
}
