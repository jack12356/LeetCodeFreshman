package FindKthLargest;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]<nums[j]){
                    int t = nums[i];
                    nums[i]=nums[j];
                    nums[j]=t;
                }
            }
        }
        return nums[k-1];
    }
    public int findKthLargest_quick(int[] nums, int k) {
        return sort(nums,0,nums.length-1,nums.length-k);
    }

    public int sort(int[] nums, int low, int high, int k){
        int left = low;
        int right = high;
        int key = nums[low];

        while (left<right){
            while ((left<right&&nums[right]>=key)) right--;
            if (right>left) {
                int temp = nums[left];
                nums[left]=nums[right];
                nums[right]=temp;
            }
            while (left<right&&nums[left]<=key) left++;
            if(left<right){
                int temp = nums[left];
                nums[left]=nums[right];
                nums[right]=temp;
            }
        }
        if (left==k) return key;
        if(left>k) return sort(nums,low,left-1, k);
        return sort(nums,right+1,high, k);
    }

    public int findKthLargest_Heap(int[]nums,int k){
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

    public static void main(String[] args) {
        FindKthLargest su = new FindKthLargest();

    }
}
