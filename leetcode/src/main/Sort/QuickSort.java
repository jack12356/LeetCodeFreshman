package Sort;

import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int []nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        qucikSort(nums,0,nums.length-1);
        for (int i = 0; i < N; i++) {
            System.out.printf("%d ",nums[i]);
        }
    }

    private static void qucikSort(int[] nums, int left, int rt) {
        if(left>=rt) return;
        int key = nums[left];
        int st = left;
        int end = rt;
        while (st < end) {
            while (st < end && nums[end] >= key) {
                end--;
            }
            if(st<end) swap(nums, st, end);
            while (st < end && nums[st] <= key) {
                st++;
            }
            if(st<end) swap(nums, st, end);
        }
        qucikSort(nums, left, st - 1);
        qucikSort(nums, st + 1, rt);
    }

    private static void swap(int[] nums, int st, int end) {
        int t = nums[st];
        nums[st] = nums[end];
        nums[end] = t;
    }
}
