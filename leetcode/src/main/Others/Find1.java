import java.util.Arrays;
import java.util.Scanner;

public class Find1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String line2 = sc.nextLine();
        String[] strs1 = line1.split(" ");
        String[] strs2 = line2.split(" ");
        int[] a = new int[strs1.length];
        int[] b = new int[strs2.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(strs1[i]);
        }
        for (int i = 0; i < b.length; i++) {
            b[i] = Integer.parseInt(strs2[i]);
        }
        solve(a,b);
    }

    private static void solve(int[] a, int[] b) {
        Arrays.sort(b);
        int index = 0;
        for (int i = 0; i < a.length-1; i++) {
            if(a[i]>=a[i+1]){
                index = i+1;
                break;
            }
        }


        int key;

        if (index == a.length - 1) {
            key = Integer.MAX_VALUE;
        }else key = a[index + 1] - 1;

        int res_index = searchFirst(b,key);

        int max;
        if (index == a.length - 1) {
            max = Integer.MAX_VALUE;
        }else max = a[index + 1];

        int min = a[index - 1];

        if(res_index<b.length&&b[res_index]<max&&b[res_index]>min){
            a[index] = b[res_index];
            for (int i = 0; i <a.length; i++) {
                System.out.printf(a[i]+" ");
            }
            return;
        }
        else if(res_index>0&&b[res_index-1]<max&&b[res_index-1]>min){
            a[index] = b[res_index-1];
            for (int i = 0; i <a.length; i++) {
                System.out.print(a[i]+" ");
            }
            return;
        }
        else System.out.println("No");
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
        return left;
    }

    private static void solve_2(int[] a, int[] b) {
        int index = 0;
        for (int i = 0; i < a.length-1; i++) {
            if(a[i]>=a[i+1]){
                index = i+1;
                break;
            }
        }
        int min = a[index - 1];
        int max = Integer.MAX_VALUE;
        if (index < a.length-1) {
            max = a[index + 1];
        }
        int max_res = Integer.MIN_VALUE;
        for (int n :b) {
            if(n<max&&n>min){
                max_res = Math.max(max_res, n);
            }
        }
        if (max_res == Integer.MIN_VALUE) {
            System.out.println("No");
        }else {
            a[index] = max_res;
            for (int i = 0; i < a.length; i++) {
                System.out.println(a[i]);
            }
        }
    }
}
