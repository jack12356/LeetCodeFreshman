package Others;

import java.util.Scanner;

public class MoveCandies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        solve(n, nums);
    }

    private static void solve(int n, int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(sum%n!=0){
            System.out.println("-1");
            return;
        }
        int a = sum / n;
        int cnt = 0;
        for (int num : nums) {
            if ((num % 2) != (a % 2)) {
                System.out.println("-1");
                return;
            }
            cnt += num > a ? (num - a) : 0;
        }
        System.out.println(cnt/2);
    }
}
