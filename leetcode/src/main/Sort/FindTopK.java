package Sort;

import java.util.Arrays;

public class FindTopK {
    public static void main(String[] args) {
        FindTopK test = new FindTopK();
        int[] nums = new int[]{13,4,7,25,17,4,34,19,57};
        System.out.println(Arrays.toString(nums));
        int K = 5;
        int topK = test.findTopK(nums,K-1,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
        System.out.println(topK);
    }

    private int findTopK(int[] nums, int k,int left,int rt) {
        if (k > rt || k < left) return -1;
        int key = nums[left];
        int st = left;
        int end = rt;
        while (st<end){
            while (st<end&&nums[end]>=key) end--;
            if(st<end) swap(nums, st, end);
            while (st<end&&nums[st]<=key) st++;
            if(st<end) swap(nums, st, end);
        }
        if(st==k){
            return nums[st];
        }
        if(st>k) return findTopK(nums, k, left, st - 1);
        return findTopK(nums, k, st + 1, rt);
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    /*
    对大小为N的数组构建二叉堆的算法复杂度是O(N)。然后每次下滤的算法复杂度是O(logN)，一共下滤K次，算法复杂度是O(N+K*logN)。
     */
    public int findKthLargest(int[]nums,int k){
        int len = nums.length;
        for (int i = len/2; i>=0; i--) {
            adjustHeap(nums,i,len);
        }
        for (int i = len-1; i >= len-k ; i--) {
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
            adjustHeap(nums,0,i);
        }
        return nums[len-k];
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
