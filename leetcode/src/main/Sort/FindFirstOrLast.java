package Sort;

public class FindFirstOrLast {
    public static void main(String []args){
        int[] nums = new int[]{1, 3, 5, 6, 6, 7, 7, 7, 8, 9, 12, 14};
        int key = -2;
        int firstIndex = findFirst(nums,key);
        int lastIndex = findLast(nums,key);
        if (firstIndex >= 0 && firstIndex <= nums.length - 1) {
            System.out.printf("first index : %d, nums[index] is : %d", firstIndex, nums[firstIndex]);
        }else {
            System.out.println("did't find!");
        }
        System.out.println();
        if(lastIndex>=0&&lastIndex<=nums.length-1){
            System.out.printf("first index : %d, nums[index] is : %d",lastIndex, nums[lastIndex]);
        }else {
            System.out.println("did't find!");
        }
    }

    private static int findFirst(int[] nums, int key){
        int st = 0;
        int end = nums.length - 1;
        while (st<=end){
            int mid = st + (end - st) / 2;
            if(nums[mid]<key){
                st = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        if(st<nums.length && nums[st]==key) return st;
        return -1;
    }

    private static int findLast(int[] nums, int key) {
        int st = 0;
        int end = nums.length - 1;
        while (st<=end){
            int mid = st + (end - st) / 2;
            if(nums[mid]<=key){
                st = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        if(end>=0 && nums[end]==key) return end;
        return -1;
    }
}
