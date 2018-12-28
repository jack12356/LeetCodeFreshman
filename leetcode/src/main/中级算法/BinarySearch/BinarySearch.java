package BinarySearch;

public class BinarySearch {
    public static int bSearch(int []nums,int target){
        int st = 0,end = nums.length-1;
        while (st<=end){
            int mid = (st+end)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]<target) st=mid+1;
            else end=mid-1;
        }
        return -1;
    }
}
