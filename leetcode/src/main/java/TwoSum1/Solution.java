package TwoSum1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] rst = null;
        Arrays.sort(nums);
        for (int num:nums) {
            System.out.println(num);
        }
        labe:for (int i = 0; i<nums.length; i++) {
            for (int j=i+1;j<nums.length;j++){
                if (nums[i]+nums[j]==target)
                {
                    rst = new int[]{i, j};
                    break labe;
                }
            }
        }
        System.out.println(Arrays.toString(rst));
        return rst;
    }

    public int[] twoSum1(int[] nums, int target){
        int[] rst = null;
        Map<Integer,Integer> nummap= new HashMap<Integer,Integer>();
        for (int i = 0; i <nums.length; i++) {
            int compliment = target - nums[i];
            if (nummap.containsKey(compliment)){
                rst = new int[]{nummap.get(compliment), i};
                return rst;
            }
            nummap.put(nums[i],i);
        }
        return rst;
    }

    public static void main(String[] args) {
       int []nums = new int[]{6,8,2,3,4,1,9,0,2,6,18,35,24};
       Solution s = new Solution();
       s.twoSum1(nums,10);
    }
}
