package Sort;

import java.util.Scanner;

public class FindFirstLower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int[] nums = new int[N];
//        for (int i = 0; i < N; i++) {
//            nums[i] = sc.nextInt();
//        }
//        int key = sc.nextInt();
        int []nums = new int[]{1,2,4,7,9,13,15};

        for (int i = 0; i < 4; i++) {
            int key = sc.nextInt();
//            int res = solve(nums,key);
            int res = solve_2(nums,key);
            System.out.println(res);
        }
    }

    private static int solve(int[] nums, int key) {
        int st = 0;
        int end = nums.length - 1;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if(nums[mid]<key){
                st = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        if(st==0) return -1;
        return nums[st - 1];
    }

    private static int solve_2(int[] nums, int key) {
        int st = 0;
        int end = nums.length;
        while (st < end) {
            int mid = st + (end - st) / 2;
            if(nums[mid]<key){
                st = mid + 1;
            }else {
                end = mid;
            }
        }
        if(st==0) return -1;
        return nums[st - 1];
    }
}
