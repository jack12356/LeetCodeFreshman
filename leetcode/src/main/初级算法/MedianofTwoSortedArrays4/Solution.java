package MedianofTwoSortedArrays4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double midnums;
        double result;
        boolean less;
        int left=0,right=0,location;
        int ln1 = nums1.length;
        int ln2 = nums2.length;
        //faulse ln1 less, true ln2 less
        less=(ln1<=ln2)?false:true;
//        if (less) {
            //midnums in int1,and compare it with int2
            if (ln1 % 2 == 0) {
                midnums = (nums1[(ln1 / 2) - 1] + nums1[(ln1 / 2)]) / 2.0;
            } else {
                midnums=nums1[ln1/2];
            }
            for (int num:nums2) {
                if (midnums <= num) {
                    right = nums2.length-left;
                    break;
                }else left++;
            }
            //result in midnum move location num, odd location, even,location and +1
            location = ln2/2 - left + 1;
            int []nums= new int[2*Math.abs(location)];
            if (location>=0){
                System.arraycopy(nums2,left,nums,0,location);
                int m = (ln1 % 2 == 0) ? ((ln1 / 2) + 1) : (ln1 / 2);
                System.arraycopy(nums1,m+1,nums,location,location);
            }
            else{
                System.arraycopy(nums2,left-location,nums,0,location);
                int m = (ln1 % 2 == 0) ? ((ln1 / 2) + 1) : (ln1 / 2);
                System.arraycopy(nums1,m+1,nums,location,location);

            }
            Arrays.sort(nums);
            if ((ln1+ln2) % 2 == 0) { //if even
                result = (location >= 0) ? ((nums[location - 1] + nums[location]) / 2.0) : ((nums[nums.length - location - 1] + nums[nums.length - location - 2]) / 2.0);
            } else {
                result = (location >= 0) ? ((nums[location - 1])) : (nums[nums.length - location - 1]);
            }
        return result;
    }
    public double findMedianSortedArrays2(int A[], int B[]) {
        int n = A.length;
        int m = B.length;
        // the following call is to make sure len(A) <= len(B).
        // yes, it calls itself, but at most once, shouldn't be
        // consider a recursive solution
        if (n > m)
            return findMedianSortedArrays(B, A);

        // now, do binary search
        int k = (n + m - 1) / 2;
        int l = 0, r = Math.min(k, n); // r is n, NOT n-1, this is important!!
        while (l < r) {
            int midA = (l + r) / 2;
            int midB = k - midA;
            if (A[midA] < B[midB])
                l = midA + 1;
            else
                r = midA;
        }

        // after binary search, we almost get the median because it must be between
        // these 4 numbers: A[l-1], A[l], B[k-l], and B[k-l+1]

        // if (n+m) is odd, the median is the larger one between A[l-1] and B[k-l].
        // and there are some corner cases we need to take care of.
        int a = Math.max(l > 0 ? A[l - 1] : Integer.MIN_VALUE, k - l >= 0 ? B[k - l] : Integer.MIN_VALUE);
        if (((n + m) & 1) == 1)
            return (double) a;

        // if (n+m) is even, the median can be calculated by
        //      median = (max(A[l-1], B[k-l]) + min(A[l], B[k-l+1]) / 2.0
        // also, there are some corner cases to take care of.
        int b = Math.min(l < n ? A[l] : Integer.MAX_VALUE, k - l + 1 < m ? B[k - l + 1] : Integer.MAX_VALUE);
        return (a + b) / 2.0;
    }

    public static void main(String[] args) {
        double result;
        int []nums1=new int[]{1,3,5,7,9};
        int []nums2=new int[]{3,3,6,13,15};
        Solution solution = new Solution();
        result = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }
}