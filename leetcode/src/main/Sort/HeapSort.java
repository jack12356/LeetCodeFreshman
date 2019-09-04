package Sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int []nums = new int[]{5,3,8,5,0,13,26};
        HeapSort t = new HeapSort();
        t.heapSort(nums);
        System.out.println(Arrays.toString(nums));

    }

    private void heapSort(int[] nums){
        int len = nums.length;
        for (int i = len/2; i>=0; i--) {
            adjustHeap(nums,i,len);
        }
        for (int i = len-1; i >= 0 ; i--) {
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
            adjustHeap(nums,0,i);
        }
    }

    private void adjustHeap(int[] nums, int parent, int len) {
        int child = 2*parent+1;
        int temp = nums[parent];
        while(child<len){
            if(child+1<len&&nums[child+1]>nums[child]) child+=1;
            if(nums[parent]>=nums[child]) break;
            else {
                nums[parent] = nums[child];
                nums[child] = temp;
            }
            parent = child;
            child = 2*child+1;
        }
    }
}