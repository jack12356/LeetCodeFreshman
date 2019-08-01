import java.util.Arrays;

public class WiggleSort {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[]copy = new int[nums.length];
        for(int i = 0;i<nums.length;i++) copy[i] = nums[i];
        int end=nums.length-1;
        int mid=end/2;
        int index=0;
        while(mid>=0){
            nums[index++] = copy[mid--];
            if(index==nums.length) return;
            nums[index++] = copy[end--];
        }
    }

    public static void main(String[] args) {
        WiggleSort su = new WiggleSort();
        int[]nums = new int[]{1,1,3,4};
        su.wiggleSort(nums);
    }
}
