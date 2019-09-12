package StringAndList;

import java.util.Scanner;

/*
5 7
1 2 3 4 5
 */
public class MinLenOfOverS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int S = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int res = solve(nums, S);
        sc.close();
        System.out.println(res);
    }

    private static int solve(int[] nums, int s) {
        if(nums==null||nums.length==0) return -1;
        if(s<=0) return 0;
        int st = 0;
        int end = 0;
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        while (end<n){
            sum += nums[end];
            while (sum>=s&&st<=end){
                min = Math.min(min, end - st + 1);
                sum -= nums[st];
                st++;
            }
            end++;
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
