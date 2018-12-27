package QuickSort;

import java.util.Arrays;

public class QuickSort {
    public int[] sort(int []nums,int low,int high){
        int left = low;
        int right = high;
        int key = nums[low];
        while (left<right){
            while (left<right&&nums[right]>=key)
                right--;
            if(left<right){
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
            }
            while (left<right&&nums[left]<=key)
                left++;
            if(left<right){
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
            }
        }
        if (left>low) sort(nums,low,left-1);
        if (right<high) sort(nums,right+1,high);
        return nums;
    }

    public void qsort(int []nums){
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(sort(nums, 0, nums.length-1)));
    }

    public static void main(String[] args) {
        QuickSort su = new QuickSort();
        int []nums = new int[]{3,5,7,8,4,2,6,15};
        su.qsort(nums);
    }
}
