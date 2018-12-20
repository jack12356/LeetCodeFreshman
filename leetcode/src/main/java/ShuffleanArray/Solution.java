
package ShuffleanArray;

import java.util.Arrays;
import java.util.Random;

class Solution {
    
    private int []data;
    private int []data_random;

    private Solution(int[] nums) {
        data = nums;
        data_random=nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    private int[] reset() {
        return data;
    }

    /** Returns a random shuffling of the array. */
    private int[] shuffle() {
        int len = data_random.length;
        Random rand = new Random();
        for (int i = 0; i < len; i++) {
            int r = rand.nextInt(len);
            int temp = data_random[i];
            data_random[i] = data_random[r];
            data_random[r]=temp;
        }
        return data_random;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        Solution obj = new Solution(nums);
        int[] param_1 = obj.reset();
        int[] param_2 = obj.shuffle();
        System.out.println("reset is :"+ Arrays.toString(param_1));
        System.out.println("shuffle is :" + Arrays.toString(param_2));
    }
}


    
