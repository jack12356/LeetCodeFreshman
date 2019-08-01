public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int st,end;
        if (nums1.length==0){
            st = nums2[0];
            end = nums2[nums2.length - 1];
        }else if (nums2.length==0){
            st = nums1[0];
            end = nums1[nums1.length - 1];
        }else {
            st = Math.min(nums1[0], nums2[0]);
            end = Math.max(nums1[nums1.length - 1], nums2[nums2.length - 1]);
        }
        int end2 = end;
        int count = (nums1.length + nums2.length - 1) / 2;
        while (st < end) {
            int mid = (st + end) / 2;
            int curCnt = findLess(nums1,mid)+findLess(nums2,mid);
            if (curCnt>= count) end=mid;
            else st = mid + 1;
        }

        count = (nums1.length + nums2.length) / 2;
        int st2 = st;
        while (st2 < end2) {
            int mid = (st2 + end2) / 2;
            int curCnt = findLess(nums1,mid)+findLess(nums2,mid);
            if (curCnt>= count) end2=mid;
            else st2 = mid + 1;
        }
        return ((double)(st+st2))/2;
    }

    public int findLess(int[] nums, int n) {
        int st = 0;
        int end = nums.length - 1;
        while (st<=end){
            int mid = (st + end)/2;
            if (nums[mid]>=n) end = mid - 1;
            else st = mid + 1;
        }
        return st;
    }
}
