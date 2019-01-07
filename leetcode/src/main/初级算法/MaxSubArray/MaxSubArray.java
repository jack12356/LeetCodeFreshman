package MaxSubArray;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int len=nums.length;
        if(len==0)return 0;
        int []prices = new int[len+1];
        int max = nums[0];
        prices[0]=0;
        for (int i = 0; i < len; i++) {
            max = nums[i]>max?nums[i]:max;
            prices[i+1]=nums[i];
        }
        for (int i = 1; i < len+1; i++) {
            prices[i] += prices[i-1];
        }
        int min = Integer.MAX_VALUE;
        int profit = Integer.MIN_VALUE;
        for (int price : prices) {
            min = Math.min(min, price);
            profit = Math.max(profit, price - min);
        }
        return profit==0?max:profit;
    }

    public static void main(String[] args) {
        MaxSubArray solution = new MaxSubArray();
        int []n = new int[]{-1};
        solution.maxSubArray(n);
    }
}
