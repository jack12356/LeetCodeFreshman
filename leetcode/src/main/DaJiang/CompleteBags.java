package DaJiang;
import java.util.Scanner;

public class CompleteBags {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int N = sc.nextInt();
            int W = sc.nextInt();
            int[] w = new int[N];
            int[] v = new int[N];
            int[] num = new int[N];
            for (int i = 0; i < N; i++) {
                w[i] = sc.nextInt();
                v[i] = sc.nextInt();
                num[i] = sc.nextInt();
            }
            int res = bag4(W, w, v, num);
            System.out.println(res);
        }
        sc.close();
    }

    public static int bag4(int V, int[] weight, int[] value, int[] num) {
        int N = weight.length;
        int[][] dp = new int[N+1][V+1];
        //为了便于理解,将dp[i][0]和dp[0][j]均置为0，从1开始计算
        for(int i=1;i<N+1;i++){
            for(int j=1;j<V+1;j++){
                //如果第i件物品的重量大于背包容量j,则不装入背包
                //由于weight和value数组下标都是从0开始,故注意第i个物品的重量为weight[i-1],价值为value[i-1]
                if (i==2&&j==31){
                    System.out.println();
                }
                if(weight[i-1] > j)
                    dp[i][j] = dp[i-1][j];
                else{
                    //考虑物品的件数限制
                    int maxV = Math.min(num[i-1],j/weight[i-1]);
                    int max = dp[i-1][j];
                    for(int k=1;k<maxV+1;k++){
                        max=Math.max(max,dp[i-1][j-k*weight[i-1]]+k*value[i-1]);
                    }
                    dp[i][j] = max;
                }
            }
        }

        //则容量为V的背包能够装入物品的最大值为
        int maxValue = dp[N][V];
        int j=V;
        String numStr="";
        for(int i=N;i>0;i--){
            //若果dp[i][j]>dp[i-1][j],这说明第i件物品是放入背包的
            while(dp[i][j]>dp[i-1][j]){
                numStr = i+" "+numStr;
                j=j-weight[i-1];
            }
            if(j==0)
                break;
        }
        System.out.println(numStr);
        return dp[N][V];
    }

}
