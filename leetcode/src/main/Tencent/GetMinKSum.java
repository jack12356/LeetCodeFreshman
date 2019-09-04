package Tencent;

import java.util.Scanner;

public class GetMinKSum{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int res = solve(nums, k );
        System.out.println(res);
    }

    private static int solve(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int index = 0;
        int t = 0;
        for (int i = 0; i < k; i++) {
            t += nums[i];
        }
        if(min>t){
            min = t;
            index = 1;
        }
        for (int i = k; i < nums.length; i++) {
            t = t - nums[i - k] + nums[i];
            if(t<min){
                min = t;
                index = i - k + 1 + 1;
            }
        }
        return index;
    }

}