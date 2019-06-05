package KickStart;

import java.util.*;

public class RoundB2 {

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        RoundB2 test = new RoundB2();
        int T = input.nextInt();
        for (int i = 0; i < T; i++) {
            int N = input.nextInt();
            int []S=new int[N];
            int []E=new int[N];
            int []L=new int[N];
            for (int j = 0; j < N; j++) {
                S[i] = input.nextInt();
                E[i] = input.nextInt();
                L[i] = input.nextInt();
            }
            test.solve(S, E, L);
        }
    }
    public int solve(int []S,int[]E,int[]L){

        return 0;
    }
}