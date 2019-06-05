import java.util.Arrays;
import java.util.Scanner;

public class MaxMin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []nums =new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
        MaxMin test = new MaxMin();
        System.out.println(test.getRes(nums));
    }

    private int getRes(int[] nums) {
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int st=0,end = nums.length-1;
        while (st<end){
            int cur = nums[st]+nums[end];
            max = Math.max(max,cur);
            min = Math.min(min,cur);
            st++;
            end--;
        }
        return max-min;
    }
}
