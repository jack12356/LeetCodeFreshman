package TitleToNumber;

public class TitleToNumber {
    public int titleToNumber(String s) {
//        char []chars = s.toCharArray();
        int res = 0;
        for (int i = 0; i < s.length() ; i++) {
            res = res*26+(s.charAt(i)-'A'+1);
        }
        return res;
    }
    public double myPow(double x, int n) {
        double res = 1;
        if (n>=0){
            while (n>0){
                if (n%2==1) {
                    res*=x;
                    n--;
                }else {
                    x *= x;
                    n /= 2;
                }
            }
        }else {
            while (n<0){
                if (n%2==-1) {
                    res/=x;
                    n++;
                }else {
                    x *= x;
                    n /= 2;
                }
            }
        }
        return res;
    }

    public int mySqrt(int x) {
        int st = 1, end = x;
        while (st<=end){
            int mid = (st+end)/2;
            if(x/mid<mid){
                end = mid - 1;
            } else st = mid + 1;
        }
        return st - 1;
    }
}
