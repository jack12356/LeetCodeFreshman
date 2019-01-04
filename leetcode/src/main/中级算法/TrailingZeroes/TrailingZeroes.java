package TrailingZeroes;

public class TrailingZeroes {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 1)
            count += (n /= 5);
        return count;
    }

    public long factorize(int n ){
        long t = 0;
        while(n!=1){
            t+=n*n;
            n--;
        }
        return t;
    }
}
