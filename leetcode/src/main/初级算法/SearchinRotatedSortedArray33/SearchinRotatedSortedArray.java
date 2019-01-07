package SearchinRotatedSortedArray33;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.
 */
public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums.length ==0) {return -1;}
        int n = nums[0], left = 0, right = nums.length - 1;
        int i = left + (right - left) / 2;
        while (left<=right) {
            if (i>0&&nums[i - 1] >= n && nums[i] <= n) break;
            if (nums[i] >= n) {
                left = i+1;
            } else {right = i-1;}
            i = left + (right - left) / 2;
        }
        if (left>right) i=right;
        return Math.max(BinarySearch(nums, 0, i - 1,target),BinarySearch(nums, i, nums.length-1,target));
    }

    private int BinarySearch(int[] nums, int left, int right,int target) {
        while (left <= right) {
            int i=left+(right - left)/2;
            if (nums[i] == target) {return i;}
            if (nums[i] < target) {left = i + 1;}
            else right = i-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,3};
        SearchinRotatedSortedArray test = new SearchinRotatedSortedArray();
        System.out.println(test.search(nums, 5));
    }
}
