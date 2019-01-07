package FourSumOfTarget18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 Note: The solution set must not contain duplicate quadruplets.
 For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 A solution set is:
 [  [-1,  0, 0, 1],
    [-2, -1, 1, 2],
    [-2,  0, 0, 2]  ]
 */

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len<4) return res;
        Arrays.sort(nums);
        int l0 = 0, r0 = len - 1;
        int count = 0;
        while (l0 < r0 - 2) {
            if (l0>0){if (nums[l0] == nums[l0 - 1]) {l0++;continue;}}
            if (r0<len-1){if (nums[r0] == nums[r0 + 1]) {r0--;continue;}}
            int l1 = l0 + 1,r1 = r0 - 1;
            int lrSum = nums[l0] + nums[r0];
            int com = lrSum + nums[l1] + nums[r1] - target;
            while (l1 < r1) {
                if (l1>l0+1&&(nums[l1] == nums[l1 - 1])) {l1++;continue;}
                if (r1<r0-1&&(nums[r1] == nums[r1 + 1])) {r1--;continue;}
                com = lrSum + nums[l1] + nums[r1] - target;
                if (com==0) {res.add(Arrays.asList(nums[l0], nums[l1], nums[r0], nums[r1]));l1++;r1--;continue;}
                if (com<0) l1++;else r1--;
            }
            switch (count) {
                case 0:{l0++;count++;break;}
                case 1:{l0--;r0--;count++;break;}
                case 2:{l0++;count=0;break;}
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int []nums = new int[]{-1,0,1,2,-1,-4};
        Solution solution = new Solution();
        System.out.println(solution.fourSum(nums, -1));
    }
}
