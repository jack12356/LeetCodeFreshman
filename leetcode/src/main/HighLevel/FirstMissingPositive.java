public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if (nums.length==0) return 1;
        for (int num : nums) {
            if (num > 0 && num <= nums.length) {
                replace_ele(nums, num, num - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=i+1) return i+1;
        }
        return nums.length+1;
    }

    private void replace_ele(int[] nums, int n, int index) {
        int t = nums[index];
        nums[index] = n;
        if (t>0 && t<=nums.length) replace_ele(nums,t,t-1);
    }

    public static void main(String[] args) {
        FirstMissingPositive su = new FirstMissingPositive();
        int []nums = new int[]{1};
        System.out.println(su.firstMissingPositive(nums));
    }
}
