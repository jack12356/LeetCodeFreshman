package leetcode其他题目;

public class CountNum1 {
    public int countDigitOne(int n) {
        int count = 0, previous = 0, coef = 1;
        while (n>0) {
            int remain = n % 10;
            int over = n / 10;
            if (remain > 1) {
                count += coef;
            } else if (remain == 1) {
                count += previous + 1;
            }
            count += coef * over;
            previous += coef * remain;
            coef *= 10;
            n /= 10;
        }
            return count;
    }
}
