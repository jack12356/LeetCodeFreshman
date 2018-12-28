package CanJump;

public class CanJump {
    public boolean canJump(int[] nums) {
        if(nums.length<=1) return true;
        boolean []jump = new boolean[nums.length];
        jump[0]=true;
        for (int i = 0; i < nums.length; i++) {
            if (jump[i]){
                int max_step = nums[i];
                for (int j = 1; j <= max_step&&j+i<nums.length; j++) {
                    jump[i+j] = true;
                }
            }
        }
        return jump[nums.length-1];
    }
}
