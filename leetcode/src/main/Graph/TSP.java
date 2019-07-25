import java.util.Scanner;

public class TSP {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] map = new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                map[i][j] = in.nextInt();
            }
        }
        solve(n,map);
    }
    public static void solve(int n,int[][]map){
        //dp[i][j]表示从i出发，经过j集合里的所有节点一次回到0点的最小小费
        int V = 1<<(n-1);  //
        int[][] dp = new int[n][V];
        for(int i=0;i<n;i++) {     // 先求dp表第一列
            dp[i][0] = map[i][0];   //每个城市回到起点的距离
        }

        for(int j=1;j<V;j++) {                  // 再求其他列
            for(int i=0;i<n;i++) {              //从i出发，要去包含j = {010101} 的城市
//                dp[i][j] = 100000;               //或者用 0x7ffff表示无穷大
                dp[i][j] = 0x7ffff;
                if(((j >> (i-1)) & 1) == 1) {    //如果已经到过j了，就continue跳出循环
                    continue;
                }
                for(int k=1;k<n;k++) {          //看能不能先到k城市
                    if(((j >> (k-1)) & 1) == 1) {  //能到
                        dp[i][j] = Math.min(dp[i][j], map[i][k] + dp[k][j ^ (1 << (k-1))]);
                    }
                }
            }
        }
        System.out.println(dp[0][(1 << (n-1))-1]);

        /*
         *以下为打印dp表
         */
        System.out.printf("%10d",0);
        for(int j = 0;j < 1 << (n - 1) ;j++){
            System.out.printf("%10d",j);
        }
        System.out.println();
        for(int i = 0;i < n;i++){
            System.out.printf("%10d",i);
            for(int j = 0;j < 1 << (n - 1) ;j++){
                if(dp[i][j] == 0x7ffff) dp[i][j] = -1;
                System.out.printf("%10d",dp[i][j]);
            }
            System.out.println();
        }
    }
}
