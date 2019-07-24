import java.util.ArrayList;
import java.util.List;

public class CombineTarget {
    boolean find;
    public static void main(String[] args) {
        int []nums = new int[]{1,2,3,2,4,1,5,3,3};
        int target = -2;
        List<List<Integer>> ans = new CombineTarget().combine(nums, target);
        if(ans==null){
            System.out.println("ans is null!");
        }else{
            for (List<Integer>ls:ans) {
                System.out.println(ls.toString());
            }
        }
    }

    public List<List<Integer>> combine(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int sum = 0;
        List<Integer> listNums = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            listNums.add(nums[i]);
        }
        if(sum%target!=0) return null;
        find = false;
        while(listNums.size()!=0){
            List<Integer> state = new ArrayList<>();
            backtrace(listNums, target,0,state,res);
            if(!find){
                return null;
            }else{
                for (int n :state) {
                    listNums.remove(Integer.valueOf(n));
                }
                find = false;
            }
        }
        return res;
    }

    private void backtrace(List<Integer> nums, int target, int index, List<Integer> state, List<List<Integer>> res) {
        if(find||target<0){
            return;
        }
        if(target==0){
            find = true;
            res.add(new ArrayList<>(state));
            return;
        }
        for (int i = index; i < nums.size(); i++) {
            int n = nums.get(i);
            state.add(n);
            backtrace(nums, target - n, i+1, state, res);
            if(find) return;
            state.remove(Integer.valueOf(n));
        }
    }
}
