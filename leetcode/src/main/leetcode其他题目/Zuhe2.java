package leetcode其他题目;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Zuhe2 {
    public static void main(String[] args) {
        int []candidates = new int[]{10,1,2,7,6,1,5};
//        int []candidates = new int[]{1,1,6};
        List<List<Integer>> res = combinationSum2(candidates, 8);
        for (List<Integer> list:res) {
            System.out.println(list.toString());
        }
    }
    private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(res,new ArrayList<>(),candidates,target,-1,0);
        return res;
    }

    private static void dfs(List<List<Integer>> res, List<Integer> state, int[] candidates, int target, int index, int presum) {
        if(presum>target) return;
        if (presum == target) {
            res.add(new ArrayList<>(state));
            return;
        }
        for (int i = index+1; i < candidates.length; i++) {
            if (i > index + 1 && candidates[i] == candidates[i - 1]) continue;
            state.add(candidates[i]);
            dfs(res, state, candidates, target, i, presum + candidates[i]);
            state.remove(state.size() - 1);
        }
    }
}
