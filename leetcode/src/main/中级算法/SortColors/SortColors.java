package SortColors;

import java.util.HashMap;

public class SortColors {
    public void sortColors(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i]>nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
    public void sortColors_2(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i:nums) {
            if (map.containsKey(i)) map.put(i,map.get(i)+1);
            else map.put(i,1);
        }
        int i = 0;
        for (int k = 0; k < 3; k++) {
            if (map.containsKey(k))for (int j=0; j< map.get(k); j++) nums[i++] = k;
        }

    }
}
