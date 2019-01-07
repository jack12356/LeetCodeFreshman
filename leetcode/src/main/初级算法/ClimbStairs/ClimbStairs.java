package ClimbStairs;

public class ClimbStairs {
    public int climbStairs(int n) {
        int[] d = new int[n+1];
        d[1]=1;
        d[2]=2;
        for (int i = 3; i < n+1; i++) {
            d[i] = d[i-2]*2;
        }
        return d[n];
    }

    public int climbStairs_2(int n) {
        int i=1;
        int j=2;
        int c=1;
        return getNStair(i,j,c,n);
    }

    private int getNStair(int i, int j,int c, int n) {
        if(c==n)
            return i;
        return getNStair(j,i+j,c+1,n);
    }
}