import java.util.*;
public class DropEggs {
    public static void main(String[] args) {
        DropEggs test = new DropEggs();
        System.out.println(test.superEggDrop(2,100));
    }
    public int superEggDrop(int K, int N) {
        if(K==1) return N;
        if(N==1) return 1;
        int [][]floor = new int[K+1][N+1];      // 只针对N遍历之后每一层
        for(int k =1;k<K+1;k++){
            for(int n=1;n<N+1;n++){
                if(k==1) floor[k][n]=n;
                else if(n==1) floor[k][n] = 1;
                else{
                    int min=Integer.MAX_VALUE;
                    for(int f = 1;f<=n;f++){
                        min = Math.min( min , Math.max( floor[k][n-f] ,floor[k-1][f-1]  ) +1 );
                    }
                    floor[k][n]=min;
                }
            }
        }
        return floor[K][N];
    }
}