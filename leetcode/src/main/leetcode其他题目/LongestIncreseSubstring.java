package leetcode其他题目;

public class LongestIncreseSubstring {
    public static void main(String[] args) {
        int []nums = new int[]{2,2,2,2,2,3};
        int res = solve(nums);
        System.out.println(res);
    }
    public static int solve(int []nums){
        if(nums.length==0) return 0;
        int []t = new int[nums.length];
        int  max = 0;
        int len = 0;
        for(int i = 0;i<nums.length;i++){
            len = insert(t,nums[i],max);
            max = Math.max(len+1,max);
        }
        return max;
    }

    public static int insert(int []t,int n,int len){
        int st = 0;
        int end = len - 1;
        while(st<=end){
            int mid = st + (end - st)/2;
            if(t[mid]<=n){
                st = mid+1;
            }else{
                end = mid-1;
            }
        }
        t[st] = n;
        return st;
    }
}
