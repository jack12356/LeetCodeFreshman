import java.util.Scanner;

public class NumsSub1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int Q = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        for (int i = 0; i < Q; i++) {
            int q = sc.nextInt();
            int cnt = sub1(nums, q);
            System.out.println(cnt);
        }
    }

    private static int sub1(int[] nums, int q) {
        int left = 0;
        int rt = nums.length - 1;
        while (left <= rt) {
            int mid = left + (rt - left) / 2;
            if (nums[mid] < q) {
                left = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        int i = left;
        while (i < nums.length) {
            nums[i] -= 1;
            i++;
        }
        return nums.length - left;
    }

    private static int sub(int[] nums, int q) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= q) {
                nums[i] -= 1;
                cnt++;
            }
        }
        return cnt;
    }
}
