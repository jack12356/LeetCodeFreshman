package DivideTwoIntegers29;

import static java.lang.Math.abs;

public class Divide {
    public int divide(int dividend, int divisor) {
        if (divisor==0) return Integer.MAX_VALUE;
        int sign = (dividend > 0 && divisor > 0)||(dividend<0&&divisor<0) ? 1 : -1;
        long n = abs((long)dividend), m = abs((long)divisor);
        long res = 0;
        while (n-m>=0) {
           long sum = m;
           int count=1;
           while ((sum<<1) < n){
                sum<<=1;
                count<<=1;
           }
           res+=count;
           n-=sum;
        }
        if (sign < 0) res = -res;
        // check for overflow and return
        return res >= Integer.MAX_VALUE || res < Integer.MIN_VALUE ? Integer.MAX_VALUE : (int) res;
    }

    public static void main(String[] args) {
        Divide divide = new Divide();
        System.out.println(divide.divide(-1010369383, -2147483648));
    }
}
