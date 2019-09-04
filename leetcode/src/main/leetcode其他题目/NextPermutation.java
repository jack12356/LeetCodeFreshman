package leetcode其他题目;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while (i >= 1 && nums[i] <= nums[i - 1]) {
            i--;
        }
        if(i==0){
            swap(nums, 0, nums.length - 1);
            return;
        }
        swap(nums, i, nums.length - 1);
        i = i - 1;
        for (int j = i+1; j < nums.length; j++) {
            if (nums[j] > nums[i]) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                break;
            }
        }
    }

    private void swap(int[] nums, int st, int end) {
        while (st<end){
            int t = nums[st];
            nums[st] = nums[end];
            nums[end] = t;
            st++;
            end--;
        }
    }
}
