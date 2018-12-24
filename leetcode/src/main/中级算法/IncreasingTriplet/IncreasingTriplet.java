package IncreasingTriplet;

import java.util.Arrays;

public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums){
        int len = nums.length;
        if(len<=2) return false;
        int []nums1 = new int[len];
        int max = nums[len - 1];
        for (int i = len-1; i >=0 ; i--) {
            if (nums[i]<max) nums1[i]=1;
            else max = nums[i];
        }
        int min = nums[0];
        System.out.println(Arrays.toString(nums1));
        for (int i=0;i<len;i++) {
             if(nums[i]>min) {
                 if(nums1[i]==1) return true;
             } else min = nums[i];
        }
        return false;
    }

    public boolean increasingTriplet_2(int[] nums){
        int mid =Integer.MIN_VALUE,max =Integer.MIN_VALUE;
        for (int i = nums.length-1; i >=0 ; i--) {
            int n = nums[i];
            if (n<max){
                if (n>=mid){
                    mid = n;
                }else{
                    return true;
                }
            }else{
                max = n;
            }
        }
        return false;
    }

    public boolean increasingTriplet_1(int[] nums){
        int first =Integer.MAX_VALUE,second =Integer.MAX_VALUE;
        for(int now:nums){
            if(now<=first){
                first =now;
                continue;
            }
            if(first<now&&now<=second){
                second =now;
                continue;
            }
            if(now>second){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IncreasingTriplet solution = new IncreasingTriplet();
        int []nums = new int[]{3,5,2,1,4};
        System.out.println(solution.increasingTriplet_2(nums));
    }
}
