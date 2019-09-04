//package Tencent;
//
//import java.util.Scanner;
//
//class Box{
//    int cur;
//    boolean isNag;
//    Box(int x, boolean y){
//        cur = x;
//        isNag = y;
//    }
//}
//
//public class GetMaxScore_5 {
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[][] nums = new int[n][3];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < 3; j++) {
//                nums[i][j] = sc.nextInt();
//            }
//        }
//        int res = solve(nums);
//        System.out.println(res);
//    }
//
//    private static int solve(int[][] nums) {
////        int n = nums.length;
////        int w = nums[0].length;
////        Box[][]dp = new Box[n+1][w+1];
////        for (int i = 0; i < w; i++) {
////            dp[0][i] = new Box(0, false);
////        }
////        for (int i = 1; i < n + 1; i++) {
////            for (int j = 1; j < w + 1; j++) {
////                int max;
////
////                dp[i][j] = max;
////            }
////        }
////        return 0;
//    }
//
//
//}