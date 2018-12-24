package IncreasingTriplet;

import java.util.Arrays;

public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums){
        int len = nums.length;
        if(len<=2) return false;
        int []nums1 = new int[len];
        int max = nums[len - 1];
        int mid = nums[len - 2];
        for (int i = len-1; i >=0 ; i--) {
            if (nums[i]<max) {
                if (nums[i]<mid){
                    nums1[i]=1;
                }else mid = Math.max(mid, nums[i]);
            }
            else {
                max = nums[i];
                mid = nums[i];
            }
        }
        int sum = 0;
        System.out.println(Arrays.toString(nums1));
        for (int n:nums1) {
            sum+=n;
            if (sum==2) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        IncreasingTriplet solution = new IncreasingTriplet();
        int []nums = new int[]{1,5,3,2,4};
        System.out.println(solution.increasingTriplet(nums));
    }
}
