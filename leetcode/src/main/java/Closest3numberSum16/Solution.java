package Closest3numberSum16;

import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 For example, given array S = {-1 2 1 -4}, and target = 1.
 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

public class Solution {
    int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        int[] nums1 = new int[len + 1];
        System.arraycopy(nums, 0, nums1, 0, len);
        nums1[len] = target;
        Arrays.sort(nums1);
        int index = len;
        for (int i = 0; i < len+1; i++) {
            if (nums1[i]==target)
            {
                index = i;
                break;
            }
        }
        int l = index-1;
        int r = index+1;
//        if (nums1[r] - target == target - nums1[l]) return 3*target;
//        for (int i = 0; i < 2; i++) {
//            if (nums1[r] - target > target - nums1[l]) {
//                l--;
//            }else r++;
//        }
//        int []subNum = new int[]{};
        int[]subNum = new int[6];
        for (int i = index-3; i < index+4; i++) {
            if (i < 0 || i > len||i==index) {
                continue;
            }
            subNum[i - index - 3] = nums1[i];
        }

        return nums1[++l]+target+nums1[--r];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int []nums = new int []{3,5,6,8,4,1,9};
        System.out.println(solution.threeSumClosest(nums,5));
    }
}
