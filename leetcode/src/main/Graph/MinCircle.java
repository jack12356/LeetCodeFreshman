public class MinCircle {
    public void floyd(int n,int [][]dis,int [][]w){
        int MinCost = Integer.MAX_VALUE;
        for(int k=1;k<=n;k++){
            for(int i=1;i<k;i++)
                for(int j=i+1;j<k;j++)
                    MinCost = Math.min(MinCost,dis[i][j]+w[i][k]+w[k][j]);//跟新k点之前枚举ij求经过ijk的最小环
            for(int i=1;i<=n;i++)
                for(int j=1;j<=n;j++)
                    dis[i][j]=Math.min(dis[i][j],dis[i][k]+dis[k][j]);      //跟新k点
        }
        if (MinCost == Integer.MAX_VALUE) {
            System.out.println("It's impossible.");
        } else {
            System.out.printf("%d\n", MinCost);
        }
    }
}
