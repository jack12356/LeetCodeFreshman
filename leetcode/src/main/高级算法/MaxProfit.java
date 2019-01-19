public class MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length<2) return 0;        //一次交易都无法进行
        int b,b1=Integer.MIN_VALUE;
        int s=0,s1=0,s2=0;
        for (int i=0;i<prices.length;i++)    //通过状态转移方程计算
        {
            b = Math.max(b1,s2-prices[i]);
            s = Math.max(s1,b1+prices[i]);
            b1=b;
            s2=s1;
            s1=s;
        }
        return s;                           //返回最终一次股票抛售后所持
    }
}
