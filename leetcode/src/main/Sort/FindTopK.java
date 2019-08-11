package Sort;

import java.util.Arrays;
import java.util.List;

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
}
