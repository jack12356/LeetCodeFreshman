package LengthOfLIS;

public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if(nums.length<=1) return nums.length;
        int []dp = new int[nums.length];
        int max_max = 1;
        dp[0]=1;
        for (int i = 0; i < nums.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j]){
                    max = Math.max(max,dp[j]+1);
                }
            }
            dp[i] = max;
            max_max = Math.max(max, max_max);
        }
        return max_max;
    }

    public int lengthOfLIS_BSearch(int[] nums) {
        if(nums.length<=1) return nums.length;
        int []min_num_at_len = new int[nums.length];
        min_num_at_len[0] = nums[0];
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            int t_len = bSearch(min_num_at_len,nums[i],0,max);
            max = Math.max(max,t_len);
        }
        return max+1;
    }

    private int bSearch(int[] nums, int n, int st, int end) {
        //find the location, insert and return
//        int st = 0, end = nums.length - 1;
        while (st<=end){
            int mid = (st+end)/2;
            if (nums[mid] == n) {
                return mid;
            }
            else if(nums[mid]<n) st = mid + 1;
            else end = mid - 1;
        }
        // if(st>nums.length-1) st--;
        nums[st] = n;
        return st;
    }
}
