package Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    private  List<List<Integer>>res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        int last=0;
        List<Integer> curList = new ArrayList<>();
        res.add(new ArrayList<>(curList));

        subk(nums,curList,last);

        return res;
    }

    private void subk(int[] nums, List<Integer> curList,int last) {
        for (int i = last; i < nums.length; i++) {
            curList.add(nums[i]);
            res.add(new ArrayList<>(curList));
            subk(nums, curList,i+1);
            curList.remove(curList.size()-1);
        }
    }

    public static void main(String[] args) {
        int[]nums = new int[]{1,2,3};
        Subsets su = new Subsets();
        su.subsets(nums);
    }
}
