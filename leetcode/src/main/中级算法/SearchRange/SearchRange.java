package SearchRange;

import java.util.Arrays;

public class SearchRange {
    public static int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int st = 0,end = len-1,mid = (st+end)/2;
        boolean find = false;
        while (st<=end){
            mid = (st+end)/2;
            if(target==nums[mid]){
                find=true;
                break;
            } else if (target>nums[mid]) st=mid+1;
            else end = mid - 1;
        }
        if (find){
            int i = mid, j = mid;
            while (i>=0&&nums[i]==target) i--;
            while (j<len&&nums[j]==target) j++;
            return new int[]{i+1,j-1};
        }else {
            return new int[]{-1,-1};
        }
    }

    public static void main(String[] args) {
        int nums[] = new int[]{5,7,8};
        System.out.println(Arrays.toString(SearchRange.searchRange(nums, 4)));
    }
}
