package Permute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Permute {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute_1(int[] nums) {
        int [] visited = new int[nums.length];
        List<Integer> curNums = new ArrayList<>();
        int level=0;
        permute_digui_1(curNums,nums,level,visited);
        return res;
    }

    private void permute_digui_1(List<Integer> curNums, int[] nums,int level,int[]visited) {
        if(level==nums.length){
            res.add(new ArrayList<>(curNums));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]==0){
                visited[i]=1;
                curNums.add(nums[i]);
                permute_digui_1(curNums,nums,level+1,visited);
                curNums.remove(curNums.size()-1);
                visited[i]=0;
            }
        }
    }


    public List<List<Integer>> permute(int[] nums) {
        List<Integer> nextNums = Arrays.stream( nums).boxed().collect(Collectors.toList());
        List<Integer> curNums = new ArrayList<>();
        permute_digui(curNums,nextNums);
        return res;
    }

    private void permute_digui(List<Integer> curNums, List<Integer> nextNums) {
        if (nextNums.size()==0){
            res.add(curNums);
            return;
        }
        for (int i = 0; i < nextNums.size(); i++) {
            List<Integer> ctNums = new ArrayList<>(curNums);
            ctNums.add(nextNums.get(i));

            List<Integer> ntNums = new ArrayList<>(nextNums);
            ntNums.remove(i);

            permute_digui(ctNums,ntNums);
        }
    }

    public static void main(String[] args) {
        Permute su = new Permute();
        su.permute_1(new int[]{1,2,3});
    }

}
