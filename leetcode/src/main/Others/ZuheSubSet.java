package Others;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ZuheSubSet {
    public static void main(String[] args) {
        Set<Integer> set =new HashSet<>();
        for (int i = 1; i <= 3; i++) {
            set.add(i);
        }
        int[] nums = new int[set.size()];
        int i = 0;
        for (Integer n:set) {
            nums[i++] = n;
        }
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res, 0, new ArrayList<>());
        for (List<Integer>curList:res){
            System.out.println(curList.toString());
        }
    }

    private static void dfs(int[] nums, List<List<Integer>> res, int i, List<Integer> state) {
        if(i>=nums.length) {
            res.add(new ArrayList<>(state));
            return;
        }
        dfs(nums,res,i+1,state);
        state.add(nums[i]);
        dfs(nums,res,i+1,state);
        state.remove(Integer.valueOf(nums[i]));
    }
}
