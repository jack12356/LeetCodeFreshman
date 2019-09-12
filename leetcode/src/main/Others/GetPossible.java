package Others;

public class GetPossible {
    public static void main(String[] args) {
        double res = solve(100, 4,3);
        System.out.printf("%.5f",res);  // res is 0.86290
    }

    private static float solve(float sum, float bad,int cnt) {
        if(cnt==0) return 1F;
        float p = (bad/sum)*(0.05F)*solve(sum-1,bad-1,cnt-1)+((sum-bad)/sum)*0.99F*solve(sum-1,bad,cnt-1);
        return p;
    }
}
