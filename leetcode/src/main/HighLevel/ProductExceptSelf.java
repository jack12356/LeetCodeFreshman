public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int []lfPdt = new int[nums.length];
        int []rtPdt = new int[nums.length];
        int[] output = new int[nums.length];
        lfPdt[0] = 1;
        rtPdt[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) lfPdt[i] = lfPdt[i-1]*nums[i-1];
        for (int j = nums.length-2; j >= 0; j--) rtPdt[j] = rtPdt[j+1]*nums[j+1];
        for (int i = 0; i < nums.length; i++) output[i] = lfPdt[i] * rtPdt[i];
        return output;
    }
}
