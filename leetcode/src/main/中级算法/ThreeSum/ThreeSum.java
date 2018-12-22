package ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++) {
            if (i!=0&&nums[i]==nums[i-1]) continue;
            List<List<Integer>> two_result = twosum(nums,-nums[i],i+1,nums.length-1);
            result.addAll(two_result);
        }
        return result;
    }

    public List<List<Integer>> twosum(int[] nums, int target, int st, int end){
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer,Integer> com_dic = new HashMap();
        for (int i = st; i < end+1; i++) {
            if (com_dic.containsKey(nums[i])){
                if (com_dic.get(nums[i])==1){
                    List<Integer> cur_result = new ArrayList<>();
                    cur_result.add(-target);
                    cur_result.add(target - nums[i]);
                    cur_result.add(nums[i]);
                    result.add(cur_result);
                    com_dic.put(nums[i], 0);
                }
            }else{
                int compli = target-nums[i];
                com_dic.put(compli,1);
            }
        }
        return result;
    }

    public List<List<Integer>> twosum_2(int[] nums, int target, int st, int end){
        List<List<Integer>> result = new ArrayList<>();
        while(st<end){
            int sum = nums[st]+nums[end];
            if (sum==target){
                result.add(Arrays.asList(-target,nums[st],nums[end]));
                while (st < end && nums[end] == nums[end - 1]) end--;
                while (st < end && nums[st] == nums[st + 1]) st--;
                end--;
                st++;
            }else if (sum>target){
                end--;
            }else st++;
        }
        return result;
    }

    public static void main(String args[]) {
        int [] nums = new int[]{-1, 0, 1, 2, -1, -4};
        ThreeSum solution = new ThreeSum();
        List<List<Integer>> result = solution.threeSum(nums);
        System.out.println(Arrays.toString(result.toArray()));
    }

}
