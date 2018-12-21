package PasikaTriple;

import java.util.ArrayList;
import java.util.List;

public class PasikaTriple {
    private List<List<Integer>> generate(int numRows){
        List<List<Integer>> tiple = new ArrayList<>();
        List<Integer>nums_0 = new ArrayList<>();
        nums_0.add(1);
        List<Integer>pre_nums = nums_0;
        tiple.add(pre_nums);
        for (int i = 1; i < numRows; i++) {
            int len = pre_nums.size();
            List<Integer>next_nums = new ArrayList<>();
            next_nums.add(pre_nums.get(0));
            for (int j = 1; j < len; j++) {
                next_nums.add(pre_nums.get(j)+pre_nums.get(j-1));
            }
            next_nums.add(pre_nums.get(len-1));
            tiple.add(next_nums);
            pre_nums = next_nums;
        }
        return tiple;
    }
}
