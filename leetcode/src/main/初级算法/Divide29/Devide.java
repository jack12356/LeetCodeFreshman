package Divide29;

import static java.lang.Math.abs;

/**
 * Divide two integers without using multiplication, division and mod operator.
 
 If it is overflow, return MAX_INT.
 */
public class Devide {
	public int divide(int dividend, int divisor) {
		if (divisor==0) return 0;
		int count = 0;
		long result = 0;
		Boolean isNeg = false;
		if((dividend<0 && divisor>0)||(dividend>0 && divisor<0))
			isNeg = true;
		int tDividend = abs(dividend);
		int tDivisor = abs(divisor);
		int sum;
		while(tDivisor < tDividend)
		{
			count = 1+Integer.MAX_VALUE;
			sum = tDivisor;
			while((sum<<=1) < tDividend)
			{
				count<<=1;
			}
			tDividend -= (sum>>=1);
			result += count;
			if (result>=Integer.MAX_VALUE) result = Integer.MAX_VALUE;
		}
		if(tDivisor == tDividend)
			result++;
		return (int) (isNeg ? (0-result) : result);
	}
	
	public static void main(String[] args) {
		System.out.println(new Devide().divide(Integer.MAX_VALUE,1));
	}
}
