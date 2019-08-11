package PinDuoDuo;

import java.util.Arrays;
import java.util.Scanner;

public class DiffSock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.substring(1,str.length()-1);
        String []strs = str.split(", ");
        int []nums =new int[strs.length];
        for (int i = 0; i < strs.length; i++) nums[i] = Integer.parseInt(strs[i]);
        int d = sc.nextInt();
        DiffSock test = new DiffSock();
        System.out.print(String.format("%.6f",test.getRes(nums,d)));
    }

    private double getRes(int[] nums, int d) {
        double L = nums.length;
        double total = L*(L-1)/2.0;
        Arrays.sort(nums);
        int left = 0, rt = 0;
        double count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] - nums[i] <= d) {
                    count++;
                }else break;
            }
        }
        return count/total;
    }
}
