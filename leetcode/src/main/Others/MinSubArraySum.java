package Others;

import java.util.Stack;

public class MinSubArraySum {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 2, 4};
        System.out.println(sumSubarrayMins1(nums));
    }

    public static   int sumSubarrayMins1(int[] nums) {
        Stack<Integer> left = new Stack<>();
        Stack<Integer> rt = new Stack<>();
        int[] left_index = new int[nums.length];
        int[] rt_index = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            while(!left.isEmpty()&&nums[left.peek()]>nums[i]) left.pop();
            if(left.isEmpty()) {
                left_index[i] = -1;
            }else left_index[i] = left.peek();
            left.add(i);
        }
        for (int i = nums.length-1; i >=0; i--) {
            while(!rt.isEmpty()&&nums[rt.peek()]>nums[i]) rt.pop();
            if(rt.isEmpty()) {
                rt_index[i] = nums.length ;
            } else rt_index[i] = rt.peek();
            rt.add(i);
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += ((i - left_index[i]) * (rt_index[i] - i)) * nums[i];
        }
        return sum;
    }
}

