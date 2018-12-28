package SearchRotateInt;


import SearchRange.SearchRange;

import java.util.Arrays;

public class SearchRotateInt {
    public static int search(int[] nums, int target) {
        int st = 0, end = nums.length - 1;
        while (st <= end) {
            int mid = (st + end) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > nums[end]) {           //左边是有序的
                if (nums[mid] < target || target < nums[st]) st = mid + 1;
                else end = mid - 1;
            } else {                              //右边是有序的
                if (nums[mid] > target || target > nums[end]) end = mid - 1;
                else st = mid + 1;
            }
        }
        return -1;
    }

    public static int bSearch(int[] nums) {
        int st = 0, end = nums.length - 1;
        while (st <= end) {
            int mid = (st + end) / 2;
            if (nums[mid]>nums[mid+1]) return mid;
            if (nums[mid] > nums[end]) {           //左边是有序的
                st = mid + 1;
            } else {                              //右边是有序的
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int []nums = new int[]{4,5,6,7,0,1,2};
        System.out.println(SearchRotateInt.search(nums, 0));
//        System.out.println(SearchRotateInt.bSearch(nums));
    }
}
