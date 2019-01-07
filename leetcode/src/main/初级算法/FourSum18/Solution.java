package FourSum18;

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
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            int num = nums[i];
            if ((i != 0) && (num == nums[i - 1])) continue;
            int temp = target - num;
            if (num > temp / 3) break;
            int[] tempnums = new int[nums.length - i - 1];
            System.arraycopy(nums, i + 1, tempnums, 0, nums.length - i - 1);
            List<List> templists = threeSumofTarget(tempnums, temp);
            for (List templist : templists) {
                templist.add(num);
                lists.add(templist);
            }
        }
        return lists;
    }

    public List<List> threeSumofTarget(int[] nums, int target) {
        List<List> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i + 2 < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            int temp = target - nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == temp) {
                    List tempres = new ArrayList();
                    tempres.add(nums[i]);
                    tempres.add(nums[j]);
                    tempres.add(nums[k]);
                    res.add(tempres);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;  // skip same result
                    while (j < k && nums[k] == nums[k + 1]) k--;  // skip same result
                } else if (nums[j] + nums[k] > temp) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(3);

        Solution solution = new Solution();
        int []nums = new int[]{1, 0, -1, 0, -2, 2};
        System.out.println(solution.fourSum(nums,0));
    }

}
