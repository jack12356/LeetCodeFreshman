import java.util.Scanner;

public class TakeMan_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int D = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        solve2(N, D, nums);
    }

    private static void solve(int N, int D, int[] nums) {
        int cnt = 0;
        for (int i = 0; i < N - 2; i++) {
            for (int j = i+1; j < N - 1; j++) {
                if (nums[j] - nums[i] > D - 1) {
                    break;
                }
                for (int k = j+1; k < N; k++) {
                    if(nums[k]-nums[i]>D) break;
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    private static void solve2(int N, int D, int[] nums) {
        int cnt = 0;
        for (int i = 0; i < N - 2; i++) {
            int lf = i + 1;
            int rt = N;
            int max = nums[i] + D;
            while (lf < rt) {
                int mid = lf + (rt - lf) / 2;
                if (nums[mid] <= max) {
                    lf = mid+1;
                } else {
                    rt = mid;
                }
            }
            int j = lf;
            int a = j-i-1;
            int b =j-i-2;
            cnt += ((a * b) % 99997867) / 2;
        }
        System.out.println(cnt);

    }
}
