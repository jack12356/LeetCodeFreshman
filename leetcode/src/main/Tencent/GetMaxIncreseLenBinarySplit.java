package Tencent;

public class GetMaxIncreseLenBinarySplit {
    public static void main(String[] args) {
        int []nums = new int[]{2,5,1,2,3,4,5,2};
        int res = getMaxLenInSplitNums(nums,0,nums.length-1);
        System.out.println(res);
    }

    private static int getMaxLenInSplitNums(int[] nums,int l,int r) {
        if(l==r) return 1;
        int mid = l + (r - l) / 2;
        int lf_len = getMaxLenInSplitNums(nums, l, mid);
        int rt_len = getMaxLenInSplitNums(nums, mid+1, r);
        if (lf_len == mid - l + 1 && rt_len == r - mid && nums[mid + 1] > nums[mid]) {
            return lf_len + rt_len;
        }
        return Math.max(lf_len, rt_len);
    }
}
