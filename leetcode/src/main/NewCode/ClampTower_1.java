import java.util.Scanner;

public class ClampTower_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int res = new ClampTower_1().clampTower(nums);
        System.out.printf("the res is %d",res);
    }
    public int clampTower(int []nums){
        if(nums.length==0){
            return 0;
        }
        int [] c = new int[nums.length];
        int [] j = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (i == 0) {
                c[i] = n;
                j[i] = 0;
                continue;
            }
            if(i==1){
                c[i] = n;
                j[i] = 0;
                continue;
            }
            c[i] = Math.min(c[i - 1], j[i - 1]) + n;
            j[i] = Math.min(c[i - 2], c[i - 1]);
        }
        return Math.min(c[nums.length - 1], j[nums.length - 1]);
    }
}
