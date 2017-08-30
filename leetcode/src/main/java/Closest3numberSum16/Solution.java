package Closest3numberSum16;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 For example, given array S = {-1 2 1 -4}, and target = 1.
 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

public class Solution {
    int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        if (len <= 2) return -1;
        Arrays.sort(nums);
        int temp = Math.abs(nums[0]+nums[1]+nums[2]-target);
        int sum = nums[0]+nums[1]+nums[2];
        for (int i = 0; i < len - 2; i++) {
            if (i!=0&&nums[i]==nums[i-1]) continue;
            int remain = target - nums[i];
            int r = len - 1;
            int l = i + 1;
            while (l < r) {
                int comp = nums[r]+nums[l]-remain;
                if (Math.abs(comp) < temp) {
                    temp = Math.abs(comp);
                    sum = nums[i]+nums[l]+nums[r];
                }
                if (comp == 0) {
                    return nums[r] + nums[l] + nums[i];
                } else if (comp<0){
                    l++;
                } else r--;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int []nums = new int []{0,0,0};
        System.out.println(solution.threeSumClosest(nums,1));
    }
}
