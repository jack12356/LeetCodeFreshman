package Search;

import java.util.Arrays;
import java.util.Random;

public class BinarySearchFirst {
    public static void main(String[] args) {
        int []nums = new int[10];
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            nums[i] = rand.nextInt(27);
        }
        Arrays.sort(nums);
        int key = 12;
        int first = searchFirst(nums, key);
        System.out.println(first);
    }

    // 第一个可以插入的位置，如果有，就是第一个出现的位置；
    private static int searchFirst(int[] nums, int key) {
        int left = 0;
        int rt = nums.length - 1;
        while (left <= rt) {
            int mid = left + (rt - left) / 2;
            if(nums[mid]<key){
                left = mid + 1;
            }else {
                rt = mid - 1;
            }
        }
        if(nums[left]==key) return left;
        return -1;
    }
}
