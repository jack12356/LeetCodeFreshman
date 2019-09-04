package Search;

public class FindFirstDecent {
    public static void main(String []args){
        int[] nums = new int[]{8,6,4,3,5,8,15,17};
        int bad = findFirstDecentNum_2(nums);
        System.out.println(bad);
    }

    private static int findFirstDecentNum(int[] nums){
        int st = 0;
        int end = nums.length;
        while(st<end){
            int mid = st + (end - st) / 2;
            if(mid>0&&nums[mid]>nums[mid-1]){
                end = mid;
            }else{
                st = mid + 1;
            }
        }
        if(st==nums.length||st==1) return -1;
        return nums[st-1];
    }

    private static int findFirstDecentNum_2(int[] nums){
        int st = 0;
        int end = nums.length - 1;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (mid > 0 && nums[mid] > nums[mid - 1]) {
                end = mid - 1;
            }else {
                st = mid + 1;
            }
        }
        if(end ==0||end == nums.length-1) return -1;
        return nums[end];
    }
}
