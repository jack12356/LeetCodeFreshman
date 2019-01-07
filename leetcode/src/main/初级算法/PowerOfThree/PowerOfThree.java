package PowerOfThree;

import static java.lang.Math.log10;

public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if(n<=0) return false;
        if(n==1) return true;
        return isPowerOfThree(n/3)&&n%3==0;
    }

    public boolean isPowerOfThree_1(int n) {
        double tem = log10(n) / log10(3.0);
        if ((int)tem - tem == 0) // 判断一个数是否为整数的做法，值得学习
            return true;
        else
            return false;
    }
}
