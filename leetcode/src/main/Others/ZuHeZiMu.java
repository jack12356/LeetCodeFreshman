package Others;

import java.util.Scanner;

public class ZuHeZiMu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []res = new int[1];
        dfs(n,0,0,0,res);
        System.out.println(res[0]);
    }

    private static void dfs(int n, int i, int preCCnt, int preBCnt, int[] res) {
        if(i>=n){
            res[0]++;
            return;
        }
        dfs(n,i+1,preCCnt,0,res);
        if(preBCnt<=1) dfs(n,i+1,preCCnt,preBCnt+1,res);
        if(preCCnt<1) dfs(n,i+1,preCCnt+1,0,res);
    }
}
