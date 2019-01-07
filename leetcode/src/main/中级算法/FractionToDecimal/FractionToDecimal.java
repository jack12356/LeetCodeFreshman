package FractionToDecimal;

public class FractionToDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        return "";
    }

    public int getSum(int a, int b) {
        if (b == 0) return a;
        int e_sum = a ^ b;
        int carry = (a & b) << 1;
        return getSum(e_sum, carry);
    }
    public static void main(String[] args) {
        FractionToDecimal su = new FractionToDecimal();
        System.out.println(su.getSum(2, 3));
    }
}
